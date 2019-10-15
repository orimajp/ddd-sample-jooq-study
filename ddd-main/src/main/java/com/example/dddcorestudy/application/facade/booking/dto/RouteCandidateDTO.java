package com.example.dddcorestudy.application.facade.booking.dto;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public final class RouteCandidateDTO implements Serializable {

    private final List<LegDTO> legs;

    /**
     * @return An unmodifiable list DTOs.
     */
    public List<LegDTO> getLegs() {
        return Collections.unmodifiableList(legs);
    }

}
