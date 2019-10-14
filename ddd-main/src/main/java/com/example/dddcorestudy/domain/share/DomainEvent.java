package com.example.dddcorestudy.domain.share;

public interface DomainEvent<T> {

    /**
     * @param other The other domain event.
     * @return <code>true</code> if the given domain event and this event are regarded as being the same event.
     */
    boolean sameEventAs(T other);

}
