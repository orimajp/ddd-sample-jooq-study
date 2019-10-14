package com.example.dddcorestudy.application.service.dto.handling;

import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public final class HandlingEventRegistrationAttempt implements Serializable {

    private final LocalDateTime registrationTime;
    private final LocalDateTime completionTime;
    private final TrackingId trackingId;
    private final VoyageNumber voyageNumber;
    private final HandlingEvent.Type type;
    private final UnLocode unLocode;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
