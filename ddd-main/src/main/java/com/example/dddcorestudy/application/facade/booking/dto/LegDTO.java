package com.example.dddcorestudy.application.facade.booking.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public final class LegDTO implements Serializable {

    private final String voyageNumber;
    private final String from;
    private final String to;
    private final LocalDateTime loadTime;
    private final LocalDateTime unloadTime;

}
