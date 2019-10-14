package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

@EqualsAndHashCode
public class HandlingActivity implements ValueObject<HandlingActivity> {

    private HandlingEvent.Type type;
    private Location location;
    private Voyage voyage;

    public HandlingActivity(final HandlingEvent.Type type, final Location location) {
        Validate.notNull(type, "Handling event type is required");
        Validate.notNull(location, "Location is required");

        this.type = type;
        this.location = location;
    }

    public HandlingActivity(final HandlingEvent.Type type, final Location location, final Voyage voyage) {
        Validate.notNull(type, "Handling event type is required");
        Validate.notNull(location, "Location is required");
        Validate.notNull(location, "Voyage is required");

        this.type = type;
        this.location = location;
        this.voyage = voyage;
    }

    public HandlingEvent.Type type() {
        return type;
    }

    public Location location() {
        return location;
    }

    public Voyage voyage() {
        return voyage;
    }


    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(HandlingActivity other) {
        return equals(other);
    }

}
