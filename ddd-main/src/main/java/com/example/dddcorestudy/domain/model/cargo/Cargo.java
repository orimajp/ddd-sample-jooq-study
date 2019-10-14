package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingHistory;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.share.DomainObjectUtils;
import com.example.dddcorestudy.domain.share.Entity;
import org.apache.commons.lang3.Validate;

public class Cargo implements Entity<Cargo> {

    private TrackingId trackingId;
    private Location origin;
    private RouteSpecification routeSpecification;
    private Itinerary itinerary;
    private Delivery delivery;

    public Cargo(final TrackingId trackingId, final RouteSpecification routeSpecification) {
        Validate.notNull(trackingId, "Tracking ID is required");
        Validate.notNull(routeSpecification, "Route specification is required");

        this.trackingId = trackingId;
        // Cargo origin never changes, even if the route specification changes.
        // However, at creation, cargo orgin can be derived from the initial route specification.
        this.origin = routeSpecification.origin();
        this.routeSpecification = routeSpecification;

        this.delivery = Delivery.derivedFrom(
                this.routeSpecification, this.itinerary, HandlingHistory.EMPTY
        );
    }

    /**
     * The tracking id is the identity of this entity, and is unique.
     *
     * @return Tracking id.
     */
    public TrackingId trackingId() {
        return trackingId;
    }

    /**
     * @return Origin location.
     */
    public Location origin() {
        return origin;
    }

    /**
     * @return The delivery. Never null.
     */
    public Delivery delivery() {
        return delivery;
    }

    /**
     * @return The itinerary. Never null.
     */
    public Itinerary itinerary() {
        return DomainObjectUtils.nullSafe(this.itinerary, Itinerary.EMPTY_ITINERARY);
    }

    /**
     * @return The route specification.
     */
    public RouteSpecification routeSpecification() {
        return routeSpecification;
    }


    /**
     * Specifies a new route for this cargo.
     *
     * @param routeSpecification route specification.
     */
    public void specifyNewRoute(final RouteSpecification routeSpecification) {
        Validate.notNull(routeSpecification, "Route specification is required");

        this.routeSpecification = routeSpecification;
        // Handling consistency within the Cargo aggregate synchronously
        this.delivery = delivery.updateOnRouting(this.routeSpecification, this.itinerary);
    }

    /**
     * Attach a new itinerary to this cargo.
     *
     * @param itinerary an itinerary. May not be null.
     */
    public void assignToRoute(final Itinerary itinerary) {
        Validate.notNull(itinerary, "Itinerary is required for assignment");

        this.itinerary = itinerary;
        // Handling consistency within the Cargo aggregate synchronously
        this.delivery = delivery.updateOnRouting(this.routeSpecification, this.itinerary);
    }

    /**
     * Updates all aspects of the cargo aggregate status
     * based on the current route specification, itinerary and handling of the cargo.
     * <p/>
     * When either of those three changes, i.e. when a new route is specified for the cargo,
     * the cargo is assigned to a route or when the cargo is handled, the status must be
     * re-calculated.
     * <p/>
     * {@link RouteSpecification} and {@link Itinerary} are both inside the Cargo
     * aggregate, so changes to them cause the status to be updated <b>synchronously</b>,
     * but changes to the delivery history (when a cargo is handled) cause the status update
     * to happen <b>asynchronously</b> since {@link HandlingEvent} is in a different aggregate.
     *
     * @param handlingHistory handling history
     */
    public void deriveDeliveryProgress(final HandlingHistory handlingHistory) {
        // TODO filter events on cargo (must be same as this cargo)

        // Delivery is a value object, so we can simply discard the old one
        // and replace it with a new
        this.delivery = Delivery.derivedFrom(routeSpecification(), itinerary(), handlingHistory);
    }

    @Override
    public boolean sameIdentityAs(final Cargo other) {
        return other != null && trackingId.sameValueAs(other.trackingId);
    }

    /**
     * @param object to compare
     * @return True if they have the same identity
     * @see #sameIdentityAs(Cargo)
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Cargo other = (Cargo) object;
        return sameIdentityAs(other);
    }

    /**
     * @return Hash code of tracking id.
     */
    @Override
    public int hashCode() {
        return trackingId.hashCode();
    }

    @Override
    public String toString() {
        return trackingId.toString();
    }

}
