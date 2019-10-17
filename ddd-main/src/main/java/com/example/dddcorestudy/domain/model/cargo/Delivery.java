package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.handling.HandlingHistory;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.share.DomainObjectUtils;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

import static com.example.dddcorestudy.domain.model.cargo.NextExpectedActivityCalculation.NO_ACTIVITY;
import static com.example.dddcorestudy.domain.model.cargo.RoutingStatus.*;
import static com.example.dddcorestudy.domain.model.cargo.TransportStatus.*;

@EqualsAndHashCode
public class Delivery implements ValueObject<Delivery> {

    private TransportStatus transportStatus;
    private Location lastKnownLocation;
    private Voyage currentVoyage;
    private boolean misdirected;
    private LocalDateTime eta;
    private HandlingActivity nextExpectedActivity;
    private boolean isUnloadedAtDestination;
    private RoutingStatus routingStatus;
    private LocalDateTime calculatedAt;
    private HandlingEvent lastEvent;

    private static final LocalDateTime ETA_UNKOWN = null;

    /**
     * Creates a new delivery snapshot to reflect changes in routing, i.e.
     * when the route specification or the itinerary has changed
     * but no additional handling of the cargo has been performed.
     *
     * @param routeSpecification route specification
     * @param itinerary itinerary
     * @return An up to date delivery
     */
    Delivery updateOnRouting(RouteSpecification routeSpecification, Itinerary itinerary) {
        Validate.notNull(routeSpecification, "Route specification is required");

        return new Delivery(this.lastEvent, itinerary, routeSpecification);
    }

    /**
     * Creates a new delivery snapshot based on the complete handling history of a cargo,
     * as well as its route specification and itinerary.
     *
     * @param routeSpecification route specification
     * @param itinerary itinerary
     * @param handlingHistory delivery history
     * @return An up to date delivery.
     */
    static Delivery derivedFrom(RouteSpecification routeSpecification, Itinerary itinerary, HandlingHistory handlingHistory) {
        Validate.notNull(routeSpecification, "Route specification is required");
        Validate.notNull(handlingHistory, "Delivery history is required");

        final HandlingEvent lastEvent = handlingHistory.mostRecentlyCompletedEvent();

        return new Delivery(lastEvent, itinerary, routeSpecification);
    }

    /**
     * Internal constructor.
     *
     * @param lastEvent last event
     * @param itinerary itinerary
     * @param routeSpecification route specification
     */
    private Delivery(HandlingEvent lastEvent, Itinerary itinerary, RouteSpecification routeSpecification) {
        this.calculatedAt = LocalDateTime.now();
        this.lastEvent = lastEvent;

        this.misdirected = calculateMisdirectionStatus(itinerary);
        this.routingStatus = calculateRoutingStatus(itinerary, routeSpecification);
        this.transportStatus = calculateTransportStatus();
        this.lastKnownLocation = calculateLastKnownLocation();
        this.currentVoyage = calculateCurrentVoyage();
        this.eta = calculateEta(itinerary);
        this.nextExpectedActivity = calculateNextExpectedActivity(routeSpecification, itinerary);
        this.isUnloadedAtDestination = calculateUnloadedAtDestination(routeSpecification);
    }

    /**
     * @return Transport status
     */
    public TransportStatus transportStatus() {
        return transportStatus;
    }

    /**
     * @return Last known location of the cargo, or Location.UNKNOWN if the delivery history is empty.
     */
    public Location lastKnownLocation() {
        return DomainObjectUtils.nullSafe(lastKnownLocation, Location.UNKNOWN);
    }

    /**
     * @return Current voyage.
     */
    public Voyage currentVoyage() {
        return DomainObjectUtils.nullSafe(currentVoyage, Voyage.NONE);
    }

    /**
     * Check if cargo is misdirected.
     * <p/>
     * <ul>
     * <li>A cargo is misdirected if it is in a location that's not in the itinerary.
     * <li>A cargo with no itinerary can not be misdirected.
     * <li>A cargo that has received no handling events can not be misdirected.
     * </ul>
     *
     * @return <code>true</code> if the cargo has been misdirected,
     */
    public boolean isMisdirected() {
        return misdirected;
    }

    /**
     * @return Estimated time of arrival
     */
    public LocalDateTime estimatedTimeOfArrival() {
        if (eta != ETA_UNKOWN) {
            return eta;
        }
        return ETA_UNKOWN;
    }

    /**
     * @return The next expected handling activity.
     */
    public HandlingActivity nextExpectedActivity() {
        return nextExpectedActivity;
    }

    /**
     * @return True if the cargo has been unloaded at the final destination.
     */
    public boolean isUnloadedAtDestination() {
        return isUnloadedAtDestination;
    }

    /**
     * @return Routing status.
     */
    public RoutingStatus routingStatus() {
        return routingStatus;
    }

    /**
     * @return When this delivery was calculated.
     */
    public LocalDateTime calculatedAt() {
        return calculatedAt;
    }

    public Object[] getStatusTextARguments() {
        return transportStatus.getStatusTextArguments(this);
    }

    // --- Internal calculations below ---

    private TransportStatus calculateTransportStatus() {
        if (lastEvent == null) {
            return NOT_RECEIVED;
        }

        switch (lastEvent.type()) {
            case LOAD:
                return ONBOARD_CARRIER;
            case UNLOAD:
            case RECEIVE:
            case CUSTOMS:
                return IN_PORT;
            case CLAIM:
                return CLAIMED;
            default:
                return UNKNOWN;
        }
    }

    private Location calculateLastKnownLocation() {
        if (lastEvent != null) {
            return lastEvent.location();
        }
        return null;
    }

    private Voyage calculateCurrentVoyage() {
        if (transportStatus().equals(ONBOARD_CARRIER) && lastEvent != null) {
            return lastEvent.voyage();
        }
        return null;
    }

    private boolean calculateMisdirectionStatus(Itinerary itinerary) {
        if (lastEvent == null) {
            return false;
        }
        return !itinerary.isExpected(lastEvent);
    }

    private LocalDateTime calculateEta(Itinerary itinerary) {
        if (onTrack()) {
            return itinerary.finalArrivalDate();
        }
        return ETA_UNKOWN;
    }

    private HandlingActivity calculateNextExpectedActivity(RouteSpecification routeSpecification, Itinerary itinerary) {
        if (!onTrack()) return NO_ACTIVITY;
        if (lastEvent == null) return new HandlingActivity(HandlingEvent.Type.RECEIVE, routeSpecification.origin());
        return lastEvent.calculateNextActivity(itinerary);
    }

    private RoutingStatus calculateRoutingStatus(Itinerary itinerary, RouteSpecification routeSpecification) {
        if (itinerary == null) {
            return NOT_ROUTED;
        }
        if (routeSpecification.isSatisfiedBy(itinerary)) {
            return ROUTED;
        }
        return MISROUTED;
    }

    private boolean calculateUnloadedAtDestination(RouteSpecification routeSpecification) {
        return lastEvent != null &&
                HandlingEvent.Type.UNLOAD.sameValueAs(lastEvent.type()) &&
                routeSpecification.destination().sameIdentityAs(lastEvent.location());
    }

    private boolean onTrack() {
        return routingStatus.equals(ROUTED) && !misdirected;
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(Delivery other) {
        return equals(other);
    }
}
