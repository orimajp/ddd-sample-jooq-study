package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnknownVoyageException extends CannotCreateHandlingEventException {

    private final VoyageNumber voyageNumber;

    @Override
    public String getMessage() {
        return "No voyage with number " + voyageNumber.idString() + " exists in the system";
    }

}
