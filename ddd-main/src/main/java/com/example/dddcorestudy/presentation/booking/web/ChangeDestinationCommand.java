package com.example.dddcorestudy.presentation.booking.web;

import lombok.Data;

@Data
public class ChangeDestinationCommand {

    private String trackingId;
    private String unlocode;

}
