package com.example.dddcorestudy.domain.model.voyage;

import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

@EqualsAndHashCode
public final class CarrierMovement implements ValueObject<CarrierMovement> {

    private Location departureLocation;
    private Location arrivalLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    // Null object pattern
    public static final CarrierMovement NONE = new CarrierMovement(
            Location.UNKNOWN, Location.UNKNOWN,
            LocalDateTime.MIN, LocalDateTime.MIN
    );

    /**
     * @return Departure location.
     */
    public Location departureLocation() {
        return departureLocation;
    }

    /**
     * @return Arrival location.
     */
    public Location arrivalLocation() {
        return arrivalLocation;
    }

    /**
     * @return Time of departure.
     */
    public LocalDateTime departureTime() {
        return departureTime;
    }

    /**
     * @return Time of arrival.
     */
    public LocalDateTime arrivalTime() {
        return arrivalTime;
    }

    /**
     * Constructor.
     *
     * @param departureLocation location of departure
     * @param arrivalLocation location of arrival
     * @param departureTime time of departure
     * @param arrivalTime time of arrival
     */
    // TODO make package local
    public CarrierMovement(Location departureLocation,
                           Location arrivalLocation,
                           LocalDateTime departureTime,
                           LocalDateTime arrivalTime) {
        Validate.noNullElements(new Object[]{departureLocation, arrivalLocation, departureTime, arrivalTime});
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(CarrierMovement other) {
        return equals(other);
    }

}
