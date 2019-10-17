package com.example.dddcorestudy.presentation.tracking;

import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.Delivery;
import com.example.dddcorestudy.domain.model.cargo.HandlingActivity;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public final class CargoTrackingViewAdapter {

    private final Cargo cargo;
    private final MessageSource messageSource;
    private final Locale locale;
    private final List<HandlingEventViewAdapter> events;
    private final ZoneId zoneId;
    private final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public CargoTrackingViewAdapter(Cargo cargo, MessageSource messageSource, Locale locale, List<HandlingEvent> handlingEvents) {
        this(cargo, messageSource, locale, handlingEvents, ZoneId.systemDefault());
    }

    public CargoTrackingViewAdapter(Cargo cargo, MessageSource messageSource, Locale locale, List<HandlingEvent> handlingEvents, ZoneId zoneId) {
        this.cargo = cargo;
        this.messageSource = messageSource;
        this.locale = locale;
        this.zoneId = zoneId;
        this.events = handlingEvents.stream().map(HandlingEventViewAdapter::new).collect(Collectors.toList());
    }

    /**
     * @param location a location
     * @return A formatted string for displaying the location.
     */
    private String getDisplayText(Location location) {
        return location.name();
    }

    /**
     * @return An unmodifiable list of handling event view adapters.
     */
    public List<HandlingEventViewAdapter> getEvents() {
        return Collections.unmodifiableList(events);
    }

    /**
     * @return A translated string describing the cargo status.
     */
    public String getStatusText() {
        final Delivery delivery = cargo.delivery();
        final String code = "cargo.status." + delivery.transportStatus().name();
        final Object[] args = delivery.getStatusTextARguments();
        return messageSource.getMessage(code, args, "[Unknown status]", locale);
    }

    /**
     * @return Cargo destination location.
     */
    public String getDestination() {
        return getDisplayText(cargo.routeSpecification().destination());
    }

    /**
     * @return Cargo osigin location.
     */
    public String getOrigin() {
        return getDisplayText(cargo.origin());
    }

    /**
     * @return Cargo tracking id.
     */
    public String getTrackingId() {
        return cargo.trackingId().idString();
    }

    public String getEta() {
        final LocalDateTime eta = cargo.delivery().estimatedTimeOfArrival();
        if (eta == null) return "?";
        return eta.format(FORMAT);
    }

    public String getNextExpectedActivity() {
        final HandlingActivity activity = cargo.delivery().nextExpectedActivity();
        if (activity == null) {
            return "";
        }

        return activity.getNextExpectedActivity();
    }

    /**
     * @return True if cargo is misdirected.
     */
    public boolean isMisdirected() {
        return cargo.delivery().isMisdirected();
    }

    /**
     * Handling event view adapter component.
     */
    @RequiredArgsConstructor
    public final class HandlingEventViewAdapter {

        private final HandlingEvent handlingEvent;

        /**
         * @return Location where the event occurred.
         */
        public String getLocation() {
            return handlingEvent.location().name();
        }

        /**
         * @return Time when the event was completed.
         */
        public String getTime() {
            return handlingEvent.completionTime().atZone(zoneId).format(FORMAT);
        }

        /**
         * @return Type of event.
         */
        public String getType() {
            return handlingEvent.type().toString();
        }

        /**
         * @return Voyage number, or empty string if not applicable.
         */
        public String getVoyageNumber() {
            final Voyage voyage = handlingEvent.voyage();
            return voyage.voyageNumber().idString();
        }

        /**
         * @return True if the event was expected, according to the cargo's itinerary.
         */
        public boolean isExpected() {
            return cargo.itinerary().isExpected(handlingEvent);
        }

        public String getDescription() {
            final Object[] args = handlingEvent.getDescriptionParameter();
            final String key = "deliveryHistory.eventDescription." + handlingEvent.type().name();
            return messageSource.getMessage(key, args, locale);
        }

    }

}
