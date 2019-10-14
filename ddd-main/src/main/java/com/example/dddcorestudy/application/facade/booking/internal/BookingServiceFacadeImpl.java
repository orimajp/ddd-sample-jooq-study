package com.example.dddcorestudy.application.facade.booking.internal;

import com.example.dddcorestudy.application.facade.booking.BookingServiceFacade;
import com.example.dddcorestudy.application.facade.booking.dto.CargoRoutingDTO;
import com.example.dddcorestudy.application.facade.booking.dto.LocationDTO;
import com.example.dddcorestudy.application.facade.booking.dto.RouteCandidateDTO;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.CargoRoutingDTOAssembler;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.ItineraryCandidateDTOAssembler;
import com.example.dddcorestudy.application.facade.booking.internal.assembler.LocationDTOAssembler;
import com.example.dddcorestudy.application.service.BookingService;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceFacadeImpl implements BookingServiceFacade {

    private final CargoRoutingDTOAssembler cargoRoutingDTOAssembler;
    private final ItineraryCandidateDTOAssembler itineraryCandidateDTOAssembler;
    private final LocationDTOAssembler locationDTOAssembler;

    private final BookingService bookingService;
    private final LocationRepository locationRepository;
    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;

    @Override
    public String bookNewCargo(String origin, String destination, LocalDateTime arrivalDeadline) {
        return null;
    }

    @Override
    public CargoRoutingDTO loadCargoForRouting(String trackingId) {
        return null;
    }

    @Override
    public void assignCargoToRoute(String trackingId, RouteCandidateDTO route) {

    }

    @Override
    public void changeDestination(String trackingId, String destinationUnLocode) {

    }

    @Override
    public List<RouteCandidateDTO> requestPossibleRoutesForCargo(String trackingId) {
        return null;
    }

    @Override
    public List<LocationDTO> listShippingLocations() {
        return null;
    }

    @Override
    public List<CargoRoutingDTO> listAllCargos() {
        return null;
    }
}
