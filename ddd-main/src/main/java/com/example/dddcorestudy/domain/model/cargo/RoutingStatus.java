package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.share.ValueObject;

public enum  RoutingStatus implements ValueObject<RoutingStatus> {
    NOT_ROUTED, ROUTED, MISROUTED;


    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(final RoutingStatus other) {
        return this.equals(other);
    }

}
