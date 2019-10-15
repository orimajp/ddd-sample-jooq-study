package com.example.dddcorestudy.application.facade.booking.internal;

import com.example.dddcorestudy.application.facade.booking.BookingServiceFacade;
import com.example.dddcorestudy.application.facade.booking.dto.CargoRoutingDTO;
import com.example.dddcorestudy.application.facade.booking.dto.LocationDTO;
import com.example.dddcorestudy.application.facade.booking.dto.RouteCandidateDTO;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.CargoRoutingDTOAssembler;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.ItineraryCandidateDTOAssembler;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.LocationDTOAssembler;
import com.example.dddcorestudy.application.service.BookingService;
import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceFacadeImpl implements BookingServiceFacade {

    private final BookingService bookingService;
    private final LocationRepository locationRepository;
    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;
    private final CargoRoutingDTOAssembler cargoRoutingDTOAssembler;
    private final ItineraryCandidateDTOAssembler itineraryCandidateDTOAssembler;
    private final LocationDTOAssembler locationDTOAssembler;

    @Override
    public String bookNewCargo(String origin, String destination, LocalDateTime arrivalDeadline) {
        TrackingId trackingId = bookingService.bookNewCargo(
                new UnLocode(origin),
                new UnLocode(destination),
                arrivalDeadline
        );
        return trackingId.idString();
    }

    @Override
    public CargoRoutingDTO loadCargoForRouting(String trackingId) {
        final Cargo cargo = cargoRepository.find(new TrackingId(trackingId)).orElseThrow(() -> new IllegalArgumentException("cargoが見つかりません。"));
        return cargoRoutingDTOAssembler.toDTO(cargo);
    }

    @Override
    public void assignCargoToRoute(String trackingIdStr, RouteCandidateDTO route) {
        final Itinerary itinerary  = itineraryCandidateDTOAssembler.fromDTO(route, voyageRepository, locationRepository);
        final TrackingId trackingId = new TrackingId(trackingIdStr);
        bookingService.assignCargoToRoute(itinerary, trackingId);
    }

    @Override
    public void changeDestination(String trackingId, String destinationUnLocode) {
        bookingService.changeDestination(new TrackingId(trackingId), new UnLocode(destinationUnLocode));
    }

    @Override
    public List<RouteCandidateDTO> requestPossibleRoutesForCargo(String trackingId) {
        final List<Itinerary> itineraries = bookingService.requestPossibleRoutesForCargo(new TrackingId(trackingId));
        return itineraries.stream().map(itineraryCandidateDTOAssembler::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> listShippingLocations() {
        final List<Location> allLocations = locationRepository.findAll();
        return locationDTOAssembler.toDTOList(allLocations);
    }

    @Override
    public List<CargoRoutingDTO> listAllCargos() {
        final List<Cargo> cargos = cargoRepository.findAll();
        return cargos.stream().map(cargoRoutingDTOAssembler::toDTO).collect(Collectors.toList());
    }

}
