package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.share.Specification;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

@EqualsAndHashCode
public class RouteSpecification implements Specification<Itinerary>, ValueObject<RouteSpecification> {

    private Location origin;
    private Location destination;
    private LocalDateTime arrivalDeadline;

    /**
     * @param origin origin location - can't be the same as the destination
     * @param destination destination location - can't be the same as the origin
     * @param arrivalDeadline arrival deadline
     */
    public RouteSpecification(final Location origin, final Location destination, final LocalDateTime arrivalDeadline) {
        Validate.notNull(origin, "Origin is required");
        Validate.notNull(destination, "Destination is required");
        Validate.notNull(arrivalDeadline, "Arrival deadline is required");
        Validate.isTrue(!origin.sameIdentityAs(destination), "Origin and destination can't be the same: " + origin);

        this.origin = origin;
        this.destination = destination;
        this.arrivalDeadline = arrivalDeadline;
    }

    /**
     * @return Specified origin location.
     */
    public Location origin() {
        return origin;
    }

    /**
     * @return Specfied destination location.
     */
    public Location destination() {
        return destination;
    }

    /**
     * @return Arrival deadline.
     */
    public LocalDateTime arrivalDeadline() {
        return arrivalDeadline;
    }

    @Override
    public boolean isSatisfiedBy(final Itinerary itinerary) {
        return itinerary != null &&
                origin().sameIdentityAs(itinerary.initialDepartureLocation()) &&
                destination().sameIdentityAs(itinerary.finalArrivalLocation()) &&
                arrivalDeadline().isAfter(itinerary.finalArrivalDate());
    }


    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(RouteSpecification other) {
        return equals(other);
    }

}
