package com.example.dddcorestudy.application.service.impl;

import com.example.dddcorestudy.application.service.BookingService;
import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    /**
     * Registers a new cargo in the tracking system, not yet routed.
     *
     * @param origin          cargo origin
     * @param destination     cargo destination
     * @param arrivalDeadline arrival deadline
     * @return Cargo tracking id
     */
    @Override
    public TrackingId bookNewCargo(UnLocode origin, UnLocode destination, LocalDateTime arrivalDeadline) {
        return null;
    }

    /**
     * Requests a list of itineraries describing possible routes for this cargo.
     *
     * @param trackingId cargo tracking id
     * @return A list of possible itineraries for this cargo
     */
    @Override
    public List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId) {
        return null;
    }

    /**
     * @param itinerary  itinerary describing the selected route
     * @param trackingId cargo tracking id
     */
    @Override
    public void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId) {

    }

    /**
     * Changes the destination of a cargo.
     *
     * @param trackingId cargo tracking id
     * @param unLocode   UN locode of new destination
     */
    @Override
    public void changeDestination(TrackingId trackingId, UnLocode unLocode) {

    }
}
