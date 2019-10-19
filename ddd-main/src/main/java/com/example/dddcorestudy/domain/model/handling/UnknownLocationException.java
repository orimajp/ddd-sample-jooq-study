package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.location.UnLocode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnknownLocationException extends CannotCreateHandlingEventException {

    private final UnLocode unlocode;

    @Override
    public String getMessage() {
        return "No location with UN locode " + unlocode.idString() + " exists in the system";
    }

}
