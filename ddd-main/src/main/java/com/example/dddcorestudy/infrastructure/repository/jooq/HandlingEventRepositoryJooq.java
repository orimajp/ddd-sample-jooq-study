package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.handling.HandlingEventRepository;
import com.example.dddcorestudy.domain.model.handling.HandlingHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HandlingEventRepositoryJooq implements HandlingEventRepository {
    /**
     * Stores a (new) handling event.
     *
     * @param event handling event to save
     */
    @Override
    public void store(HandlingEvent event) {

    }

    /**
     * @param trackingId cargo tracking id
     * @return The handling history of this cargo
     */
    @Override
    public HandlingHistory lookupHandlingHistoryOfCargo(TrackingId trackingId) {
        return null;
    }
}
