package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class HandlingEventFactory {

    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;
    private final LocationRepository locationRepository;

    /**
     * @param registrationTime  time when this event was received by the system
     * @param completionTime    when the event was completed, for example finished loading
     * @param trackingId        cargo tracking id
     * @param voyageNumber      voyage number
     * @param unlocode          United Nations Location Code for the location of the event
     * @param type              type of event
     * @throws UnknownVoyageException   if there's no voyage with this number
     * @throws UnknownCargoException    if there's no cargo with this tracking id
     * @throws UnknownLocationException if there's no location with this UN Locode
     * @return A handling event.
     */
    public HandlingEvent createHandlingEvent(LocalDateTime registrationTime, LocalDateTime completionTime, TrackingId trackingId, VoyageNumber voyageNumber, UnLocode unlocode, HandlingEvent.Type type)
            throws CannotCreateHandlingEventException {
        final Cargo cargo = findCargo(trackingId);
        final Voyage voyage = findVoyage(voyageNumber);
        final Location location = findLocation(unlocode);

        try {
            if (voyage == null) {
                return new HandlingEvent(cargo, completionTime, registrationTime, type, location);
            }
            return new HandlingEvent(cargo, completionTime, registrationTime, type, location, voyage);
        } catch (Exception e) {
            throw new CannotCreateHandlingEventException(e);
        }
    }

    private Cargo findCargo(TrackingId trackingId) throws UnknownCargoException {
        return cargoRepository.find(trackingId).orElseThrow(() -> new UnknownCargoException(trackingId));
    }

    private Voyage findVoyage(VoyageNumber voyageNumber) throws UnknownVoyageException {
        if (voyageNumber == null) {
            return null;
        }

        final Voyage voyage = voyageRepository.find(voyageNumber);
        if (voyage == null) {
            throw new UnknownVoyageException(voyageNumber);
        }

        return voyage;
    }

    private Location findLocation(final UnLocode unlocode) throws UnknownLocationException {
        return locationRepository.find(unlocode).orElseThrow(() -> new UnknownLocationException(unlocode));
    }

}
