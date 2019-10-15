package com.example.dddcorestudy.application.service;

import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.location.UnLocode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Cargo booking service.
 */
public interface BookingService {

  /**
   * Registers a new cargo in the tracking system, not yet routed.
   *
   * @param origin      cargo origin
   * @param destination cargo destination
   * @param arrivalDeadline arrival deadline
   * @return Cargo tracking id
   */
  TrackingId bookNewCargo(UnLocode origin, UnLocode destination, LocalDateTime arrivalDeadline);

  /**
   * Requests a list of itineraries describing possible routes for this cargo.
   *
   * @param trackingId cargo tracking id
   * @return A list of possible itineraries for this cargo
   */
  List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId);

  /**
   * @param itinerary itinerary describing the selected route
   * @param trackingId cargo tracking id
   */
  void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId);

  /**
   * Changes the destination of a cargo.
   *
   * @param trackingId cargo tracking id
   * @param unLocode UN locode of new destination
   */
  void changeDestination(TrackingId trackingId, UnLocode unLocode);

}
