package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.share.ValueObject;
import org.apache.commons.lang3.Validate;

public final class TrackingId implements ValueObject<TrackingId> {

    private String id;

    public TrackingId(final String id) {
        Validate.notNull(id);
        this.id = id;
    }

    /**
     * @return String representation of this tracking id.
     */
    public String idString() {
        return id;
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(TrackingId other) {
        return false;
    }
}
