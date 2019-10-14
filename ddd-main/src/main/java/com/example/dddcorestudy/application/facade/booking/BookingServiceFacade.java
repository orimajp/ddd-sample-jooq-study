package com.example.dddcorestudy.application.facade.booking;

import com.example.dddcorestudy.application.facade.booking.dto.CargoRoutingDTO;
import com.example.dddcorestudy.application.facade.booking.dto.LocationDTO;
import com.example.dddcorestudy.application.facade.booking.dto.RouteCandidateDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingServiceFacade {

    String bookNewCargo(String origin, String destination, LocalDateTime arrivalDeadline);

    CargoRoutingDTO loadCargoForRouting(String trackingId);

    void assignCargoToRoute(String trackingId, RouteCandidateDTO route);

    void changeDestination(String trackingId, String destinationUnLocode);

    List<RouteCandidateDTO> requestPossibleRoutesForCargo(String trackingId);

    List<LocationDTO> listShippingLocations();

    List<CargoRoutingDTO> listAllCargos();

}
