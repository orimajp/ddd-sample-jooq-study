package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.share.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.*;

public class HandlingHistory implements ValueObject<HandlingHistory> {

    private final List<HandlingEvent> handlingEvents;

    public static final HandlingHistory EMPTY = new HandlingHistory(Collections.emptyList());

    public HandlingHistory(Collection<HandlingEvent> handlingEvents) {
        Validate.notNull(handlingEvents, "Handling events are required");

        this.handlingEvents = new ArrayList<>(handlingEvents);
    }

    /**
     * @return A distinct list (no duplicate registrations) of handling events, ordered by completion time.
     */
    public List<HandlingEvent> distinctEventsByCompletionTime() {
        final List<HandlingEvent> ordered = new ArrayList<>(
                new HashSet<>(handlingEvents)
        );
        ordered.sort(BY_COMPLETION_TIME_COMPARATOR);
        return Collections.unmodifiableList(ordered);
    }

    /**
     * @return Most recently completed event, or null if the delivery history is empty.
     */
    public HandlingEvent mostRecentlyCompletedEvent() {
        final List<HandlingEvent> distinctEvents = distinctEventsByCompletionTime();
        if (distinctEvents.isEmpty()) {
            return null;
        }
        return distinctEvents.get(distinctEvents.size() - 1);
    }

    @Override
    public boolean sameValueAs(HandlingHistory other) {
        return other != null && this.handlingEvents.equals(other.handlingEvents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final HandlingHistory other = (HandlingHistory) o;
        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return handlingEvents.hashCode();
    }

    private static final Comparator<HandlingEvent> BY_COMPLETION_TIME_COMPARATOR =
            Comparator.comparing(HandlingEvent::completionTime);

}
