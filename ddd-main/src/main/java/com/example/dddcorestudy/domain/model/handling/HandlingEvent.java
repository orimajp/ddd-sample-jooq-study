package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.cargo.*;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.share.DomainEvent;
import com.example.dddcorestudy.domain.share.DomainObjectUtils;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public final class HandlingEvent implements DomainEvent<HandlingEvent> {

    private Type type;
    private Voyage voyage;
    private Location location;
    private LocalDateTime completionTime;
    private LocalDateTime registrationTime;
    private Cargo cargo;

    @RequiredArgsConstructor
    public enum Type implements ValueObject<Type>, ItineraryEventExpection, NextExpectedActivityCalculation {
        LOAD(true) {
            @Override
            public boolean isItinerayExpected(Itinerary itinerary, HandlingEvent event) {
                return isExpectedForLoad(itinerary, event);
            }

            @Override
            public HandlingActivity calculateNextActivity(Itinerary itinerary, HandlingEvent lastEvent) {
                return calculateNextActivityForLoad(itinerary, lastEvent);
            }
        },
        UNLOAD(true) {
            @Override
            public boolean isItinerayExpected(Itinerary itinerary, HandlingEvent event) {
                return isExpectedForUnload(itinerary, event);
            }

            @Override
            public HandlingActivity calculateNextActivity(Itinerary itinerary, HandlingEvent lastEvent) {
                return calculateNextActivityForUnload(itinerary, lastEvent);
            }
        },
        RECEIVE(false) {
            @Override
            public boolean isItinerayExpected(Itinerary itinerary, HandlingEvent event) {
                return isExpectedForRecieve(itinerary, event);
            }

            @Override
            public HandlingActivity calculateNextActivity(Itinerary itinerary, HandlingEvent lastEvent) {
                return calculateNextActivityForReceive(itinerary, lastEvent);
            }
        },
        CLAIM(false) {
            @Override
            public boolean isItinerayExpected(Itinerary itinerary, HandlingEvent event) {
                return isExpectedForClaim(itinerary, event);
            }
        },
        CUSTOMS(false);

        private final boolean voyageRequired;

        /**
         * @return True if a voyage association is required for this event type.
         */
        public boolean requiresVoyage() {
            return voyageRequired;
        }

        /**
         * @return True if a voyage association is prohibited for this event type.
         */
        public boolean prohibitsVoyage() {
            return !requiresVoyage();
        }

        public boolean isItinerayExpected(Itinerary itinerary, HandlingEvent event) {
            return isExpectedForDefault(itinerary, event);
        }

        public HandlingActivity calculateNextActivity(Itinerary itinerary, HandlingEvent lastEvent) {
            return calculateNextActivityDefault(itinerary, lastEvent);
        }

        /**
         * Value objects compare by the values of their attributes, they don't have an identity.
         *
         * @param other The other value object.
         * @return <code>true</code> if the given value object's and this value object's attributes are the same.
         */
        @Override
        public boolean sameValueAs(Type other) {
            return this.equals(other);
        }
    }

    /**
     * @param cargo            cargo
     * @param completionTime   completion time, the reported time that the event actually happened (e.g. the receive took place).
     * @param registrationTime registration time, the time the message is received
     * @param type             type of event
     * @param location         where the event took place
     * @param voyage           the voyage
     */
    public HandlingEvent(final Cargo cargo,
                         final LocalDateTime completionTime,
                         final LocalDateTime registrationTime,
                         final Type type,
                         final Location location,
                         final Voyage voyage) {
        Validate.notNull(cargo, "Cargo is required");
        Validate.notNull(completionTime, "Completion time is required");
        Validate.notNull(registrationTime, "Registration time is required");
        Validate.notNull(type, "Handling event type is required");
        Validate.notNull(location, "Location is required");
        Validate.notNull(voyage, "Voyage is required");

        if (type.prohibitsVoyage()) {
            throw new IllegalArgumentException("Voyage is not allowed with event type " + type);
        }

        this.voyage = voyage;
        this.completionTime = completionTime;
        this.registrationTime = registrationTime;
        this.type = type;
        this.location = location;
        this.cargo = cargo;
    }

    /**
     * @param cargo            cargo
     * @param completionTime   completion time, the reported time that the event actually happened (e.g. the receive took place).
     * @param registrationTime registration time, the time the message is received
     * @param type             type of event
     * @param location         where the event took place
     */
    public HandlingEvent(final Cargo cargo,
                         final LocalDateTime completionTime,
                         final LocalDateTime registrationTime,
                         final Type type,
                         final Location location) {
        Validate.notNull(cargo, "Cargo is required");
        Validate.notNull(completionTime, "Completion time is required");
        Validate.notNull(registrationTime, "Registration time is required");
        Validate.notNull(type, "Handling event type is required");
        Validate.notNull(location, "Location is required");

        if (type.requiresVoyage()) {
            throw new IllegalArgumentException("Voyage is required for event type " + type);
        }

        this.completionTime = completionTime;
        this.registrationTime = registrationTime;
        this.type = type;
        this.location = location;
        this.cargo = cargo;
        this.voyage = null;
    }

    public Type type() {
        return this.type;
    }

    public Voyage voyage() {
        return DomainObjectUtils.nullSafe(this.voyage, Voyage.NONE);
    }

    public LocalDateTime completionTime() {
        return completionTime;
    }

    public LocalDateTime registrationTime() {
        return registrationTime;
    }

    public Location location() {
        return this.location;
    }

    public Cargo cargo() {
        return this.cargo;
    }

    public boolean isItinerayExpected(Itinerary itinerary) {
        return type.isItinerayExpected(itinerary, this);
    }

    public HandlingActivity calculateNextActivity(Itinerary itinerary) {
        return type.calculateNextActivity(itinerary, this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final HandlingEvent event = (HandlingEvent) o;

        return sameEventAs(event);
    }

    @Override
    public boolean sameEventAs(final HandlingEvent other) {
        return other != null && new EqualsBuilder().
                append(this.cargo, other.cargo).
                append(this.voyage, other.voyage).
                append(this.completionTime, other.completionTime).
                append(this.location, other.location).
                append(this.type, other.type).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(cargo).
                append(voyage).
                append(completionTime).
                append(location).
                append(type).
                toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("\n--- Handling event ---\n").
                append("Cargo: ").append(cargo.trackingId()).append("\n").
                append("Type: ").append(type).append("\n").
                append("Location: ").append(location.name()).append("\n").
                append("Completed on: ").append(completionTime).append("\n").
                append("Registered on: ").append(registrationTime).append("\n");

        if (voyage != null) {
            builder.append("Voyage: ").append(voyage.voyageNumber()).append("\n");
        }

        return builder.toString();
    }

}
