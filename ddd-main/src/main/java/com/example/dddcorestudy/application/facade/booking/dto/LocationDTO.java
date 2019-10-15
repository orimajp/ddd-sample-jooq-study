package com.example.dddcorestudy.application.facade.booking.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class LocationDTO implements Serializable {

    private final String unLocode;
    private final String name;

}
