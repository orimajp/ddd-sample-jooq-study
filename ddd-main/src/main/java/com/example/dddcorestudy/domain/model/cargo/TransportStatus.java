package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.share.ValueObject;
import com.example.dddcorestudy.presentation.tracking.TransporterStatusParameter;

public enum  TransportStatus implements ValueObject<TransportStatus>, TransporterStatusParameter {
    NOT_RECEIVED,
    IN_PORT() {
        @Override
        public Object[] getStatusTextArguments(Delivery delivery) {
            return getStatusTextArgumentsForInPort(delivery);
        }
    },
    ONBOARD_CARRIER() {
        @Override
        public Object[] getStatusTextArguments(Delivery delivery) {
            return getStatusTextArgumentsForOnboardCarrier(delivery);
        }
    },
    CLAIMED,
    UNKNOWN;

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

    public Object[] getStatusTextArguments(Delivery delivery) {
        return getStatusTextArgumentsDefault(delivery);
    }

}
