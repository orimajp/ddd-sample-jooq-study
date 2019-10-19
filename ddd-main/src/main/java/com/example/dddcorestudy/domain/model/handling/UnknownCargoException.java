package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnknownCargoException extends CannotCreateHandlingEventException {

    private final TrackingId trackingId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "No cargo with tracking id " + trackingId.idString() + " exists in the system";
    }

}
