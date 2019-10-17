package com.example.dddcorestudy.presentation.tracking;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;

public interface HandlingEventDescription {

    default Object[] getDescriptionParameterExistsVoyage(HandlingEvent event) {
        return new Object[] {
                event.voyage().voyageNumber().idString(),
                event.location().name(),
                event.completionTime()
        };
    }

    default Object[] getDescriptionParameterNoVoyage(HandlingEvent event) {
        return new Object[] {
                event.location().name(),
                event.completionTime()
        };
    }

    default Object[] getDescriptionParameterDefault(HandlingEvent event) {
        return new Object[] {};
    }

}
