package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.cargo.TrackingId;

public interface HandlingEventRepository {

    /**
     * Stores a (new) handling event.
     *
     * @param event handling event to save
     */
    void store(HandlingEvent event);


    /**
     * @param trackingId cargo tracking id
     * @return The handling history of this cargo
     */
    HandlingHistory lookupHandlingHistoryOfCargo(TrackingId trackingId);

}
