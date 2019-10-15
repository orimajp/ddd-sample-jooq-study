package com.example.dddcorestudy.application.facade.booking.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CargoRoutingDTO implements Serializable {

    private final String trackingId;
    private final String origin;
    private final String finalDestination;
    private final LocalDateTime arrivalDeadline;
    private final boolean misrouted;
    private final List<LegDTO> legs = new ArrayList<>();

    public void addLeg(String voyageNumber, String from, String to, LocalDateTime loadTime, LocalDateTime unloadTime) {
        legs.add(new LegDTO(voyageNumber, from, to, loadTime, unloadTime));
    }

    /**
     * @return An unmodifiable list DTOs.
     */
    public List<LegDTO> getLegs() {
        return Collections.unmodifiableList(legs);
    }

    public boolean isRouted() {
        return !legs.isEmpty();
    }


}
