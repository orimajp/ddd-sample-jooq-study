package com.example.dddcorestudy.application.service.impl;

import com.example.dddcorestudy.application.service.CargoInspectionService;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoInspectionServiceImpl implements CargoInspectionService {
    /**
     * Inspect cargo and send relevant notifications to interested parties,
     * for example if a cargo has been misdirected, or unloaded
     * at the final destination.
     *
     * @param trackingId cargo tracking id
     */
    @Override
    public void inspectCargo(TrackingId trackingId) {

    }
}
