package com.example.dddcorestudy.application.service;

import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.CannotCreateHandlingEventException;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;

import java.time.LocalDateTime;

/**
 * Handling event service.
 */
public interface HandlingEventService {

  /**
   * Registers a handling event in the system, and notifies interested
   * parties that a cargo has been handled.
   *
   * @param completionTime when the event was completed
   * @param trackingId cargo tracking id
   * @param voyageNumber voyage number
   * @param unLocode UN locode for the location where the event occurred
   * @param type type of event
   * @throws CannotCreateHandlingEventException
   *  if a handling event that represents an actual event that's relevant to a cargo we're tracking
   *  can't be created from the parameters 
   */
  void registerHandlingEvent(LocalDateTime completionTime,
                             TrackingId trackingId,
                             VoyageNumber voyageNumber,
                             UnLocode unLocode,
                             HandlingEvent.Type type) throws CannotCreateHandlingEventException;

}
