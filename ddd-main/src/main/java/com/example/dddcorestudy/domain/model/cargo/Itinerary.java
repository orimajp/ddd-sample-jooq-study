package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
public class Itinerary implements ValueObject<Itinerary> {

    private List<Leg> legs = Collections.emptyList();

    static final Itinerary EMPTY_ITINERARY = new Itinerary();
    private static final LocalDateTime END_OF_DAYS = LocalDateTime.MAX;

    /**
     * Constructor.
     *
     * @param legs List of legs for this itinerary.
     */
    public Itinerary(final List<Leg> legs) {
        Validate.notEmpty(legs);
        Validate.noNullElements(legs);

        this.legs = legs;
    }

    /**
     * @return the legs of this itinerary, as an <b>immutable</b> list.
     */
    public List<Leg> legs() {
        return Collections.unmodifiableList(legs);
    }

    /**
     * Test if the given handling event is expected when executing this itinerary.
     *
     * @param event Event to test.
     * @return <code>true</code> if the event is expected
     */
    public boolean isExpected(final HandlingEvent event) {
        if (legs.isEmpty()) {
            return true;
        }
        return event.isItinerayExpected(this);
    }

    /**
     * @return The initial departure location.
     */
    Location initialDepartureLocation() {
        if (legs.isEmpty()) {
            return Location.UNKNOWN;
        }
        return legs.get(0).loadLocation();
    }

    /**
     * @return The final arrival location.
     */
    Location finalArrivalLocation() {
        if (legs.isEmpty()) {
            return Location.UNKNOWN;
        }
        return lastLeg().unloadLocation();
    }

    /**
     * @return Date when cargo arrives at final destination.
     */
    LocalDateTime finalArrivalDate() {
        final Leg lastLeg = lastLeg();
        if (lastLeg == null) {
            return END_OF_DAYS;
        }
        return lastLeg.unloadTime();
    }

    /**
     * @return The last leg on the itinerary.
     */
    Leg lastLeg() {
        if (legs.isEmpty()) {
            return null;
        }
        return legs.get(legs.size() - 1);
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(Itinerary other) {
        return equals(other);
    }

    private Itinerary() {}

}
