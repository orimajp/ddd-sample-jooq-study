package com.example.dddcorestudy.application.service.impl;

import com.example.dddcorestudy.application.service.BookingService;
import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.RouteSpecification;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.service.RoutingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final CargoRepository cargoRepository;
    private final LocationRepository locationRepository;
    private final RoutingService routingService;

    /**
     * Registers a new cargo in the tracking system, not yet routed.
     *
     * @param originUnLocode          cargo origin
     * @param destinationUnLocode     cargo destination
     * @param arrivalDeadline arrival deadline
     * @return Cargo tracking id
     */
    @Override
    @Transactional
    public TrackingId bookNewCargo(UnLocode originUnLocode, UnLocode destinationUnLocode, LocalDateTime arrivalDeadline) {
        // TODO modeling this as a cargo factory might be suitable
        final TrackingId trackingId = cargoRepository.nextTrackingId();
        final Location origin = locationRepository.find(originUnLocode).orElseThrow(() ->
                new IllegalArgumentException(" Can not find orign Location."));
        final Location destination = locationRepository.find(destinationUnLocode).orElseThrow(() ->
                new IllegalArgumentException(" Can not find destination Location."));
        final RouteSpecification routeSpecification = new RouteSpecification(origin, destination, arrivalDeadline);

        final Cargo cargo = new Cargo(trackingId, routeSpecification);

        cargoRepository.store(cargo);
        log.info("Booked new cargo with tracking id " + cargo.trackingId().idString());

        return cargo.trackingId();
    }

    /**
     * Requests a list of itineraries describing possible routes for this cargo.
     *
     * @param trackingId cargo tracking id
     * @return A list of possible itineraries for this cargo
     */
    @Override
    @Transactional
    public List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId) {
        return cargoRepository.find(trackingId)
                .map(cargo -> routingService.fetchRoutesForSpecification(cargo.routeSpecification()))
                .orElseGet(Collections::emptyList);
    }

    /**
     * @param itinerary  itinerary describing the selected route
     * @param trackingId cargo tracking id
     */
    @Override
    @Transactional
    public void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId) {
        final Cargo cargo = cargoRepository.find(trackingId).orElseThrow(() ->
                new IllegalArgumentException("Can not find Cargo."));

        cargo.assignToRoute(itinerary);
        cargoRepository.store(cargo);

        log.info("Assigned cargo " + trackingId + " to new route");
    }

    /**
     * Changes the destination of a cargo.
     *
     * @param trackingId cargo tracking id
     * @param unLocode   UN locode of new destination
     */
    @Override
    @Transactional
    public void changeDestination(TrackingId trackingId, UnLocode unLocode) {
        final Cargo cargo = cargoRepository.find(trackingId).orElseThrow(() ->
                new IllegalArgumentException("Can not find Cargo."));
        final Location newDestination = locationRepository.find(unLocode).orElseThrow(() ->
                new IllegalArgumentException(" Can not find Location."));

        final RouteSpecification routeSpecification = new RouteSpecification(
                cargo.origin(), newDestination, cargo.routeSpecification().arrivalDeadline());
        cargo.specifyNewRoute(routeSpecification);

        cargoRepository.store(cargo);
        log.info("Changed destination for cargo " + trackingId + " to " + routeSpecification.destination());
    }

}
