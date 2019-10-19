package com.example.dddcorestudy.application.service.impl;

import com.example.dddcorestudy.application.service.ApplicationEvents;
import com.example.dddcorestudy.application.service.HandlingEventService;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.CannotCreateHandlingEventException;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.handling.HandlingEventFactory;
import com.example.dddcorestudy.domain.model.handling.HandlingEventRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class HandlingEventServiceImpl implements HandlingEventService {

    private final ApplicationEvents applicationEvents;
    private final HandlingEventRepository handlingEventRepository;
    private final HandlingEventFactory handlingEventFactory;

    /**
     * Registers a handling event in the system, and notifies interested
     * parties that a cargo has been handled.
     *
     * @param completionTime when the event was completed
     * @param trackingId     cargo tracking id
     * @param voyageNumber   voyage number
     * @param unLocode       UN locode for the location where the event occurred
     * @param type           type of event
     * @throws CannotCreateHandlingEventException if a handling event that represents an actual event that's relevant to a cargo we're tracking
     *                                            can't be created from the parameters
     */
    @Override
    public void registerHandlingEvent(LocalDateTime completionTime, TrackingId trackingId, VoyageNumber voyageNumber, UnLocode unLocode, HandlingEvent.Type type) throws CannotCreateHandlingEventException {
        final LocalDateTime registrationTime = LocalDateTime.now();

    /* Using a factory to create a HandlingEvent (aggregate). This is where
       it is determined wether the incoming data, the attempt, actually is capable
       of representing a real handling event. */
        final HandlingEvent event = handlingEventFactory.createHandlingEvent(
                registrationTime, completionTime, trackingId, voyageNumber, unLocode, type);

    /* Store the new handling event, which updates the persistent
       state of the handling event aggregate (but not the cargo aggregate -
       that happens asynchronously!)
     */
        handlingEventRepository.store(event);

        /* Publish an event stating that a cargo has been handled. */
        applicationEvents.cargoWasHandled(event);

        log.info("Registered handling event");
    }

}
