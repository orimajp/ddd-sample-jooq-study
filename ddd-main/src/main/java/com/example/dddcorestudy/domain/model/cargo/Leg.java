package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

@EqualsAndHashCode
public class Leg implements ValueObject<Leg> {

    private Voyage voyage;
    private Location loadLocation;
    private Location unloadLocation;
    private LocalDateTime loadTime;
    private LocalDateTime unloadTime;

    public Leg(Voyage voyage, Location loadLocation, Location unloadLocation, LocalDateTime loadTime, LocalDateTime unloadTime) {
        Validate.noNullElements(new Object[] {voyage, loadLocation, unloadLocation, loadTime, unloadTime});

        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;
    }

    public Voyage voyage() {
        return voyage;
    }

    public Location loadLocation() {
        return loadLocation;
    }

    public Location unloadLocation() {
        return unloadLocation;
    }

    public LocalDateTime loadTime() {
        return loadTime;
    }

    public LocalDateTime unloadTime() {
        return unloadTime;
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(Leg other) {
        return equals(other);
    }

}
