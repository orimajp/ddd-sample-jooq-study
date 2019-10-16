package com.example.dddcorestudy.presentation.booking.web;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public final class RegistrationCommand {

    private String originUnlocode;
    private String destinationUnlocode;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime arrivalDeadline;

}
