package com.example.dddcorestudy.domain.model.handling;

import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HandlingEventFactory {

    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;
    private final LocationRepository locationRepository;

}
