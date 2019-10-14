package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.share.ValueObject;

public enum  TransportStatus implements ValueObject<TransportStatus> {
    NOT_RECEIVED, IN_PORT, ONBOARD_CARRIER, CLAIMED, UNKNOWN;

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(final TransportStatus other) {
        return this.equals(other);
    }


/*    public static TransportStatus calculateStatus(HandlingEvent.Type type) {
        if (type == null) {
            return NOT_RECEIVED;
        }
        return UNKNOWN;
    }*/

}
