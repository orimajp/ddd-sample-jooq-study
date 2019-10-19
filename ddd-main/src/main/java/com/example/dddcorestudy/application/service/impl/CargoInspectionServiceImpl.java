package com.example.dddcorestudy.application.service.impl;

import com.example.dddcorestudy.application.service.ApplicationEvents;
import com.example.dddcorestudy.application.service.CargoInspectionService;
import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.HandlingEventRepository;
import com.example.dddcorestudy.domain.model.handling.HandlingHistory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CargoInspectionServiceImpl implements CargoInspectionService {

    private final ApplicationEvents applicationEvents;
    private final CargoRepository cargoRepository;
    private final HandlingEventRepository handlingEventRepository;

    /**
     * Inspect cargo and send relevant notifications to interested parties,
     * for example if a cargo has been misdirected, or unloaded
     * at the final destination.
     *
     * @param trackingId cargo tracking id
     */
    @Override
    @Transactional
    public void inspectCargo(TrackingId trackingId) {
        Validate.notNull(trackingId, "Tracking ID is required");

        final Optional<Cargo> cargoOptional = cargoRepository.find(trackingId);
        if (!cargoOptional.isPresent()) {
            log.warn("Can't inspect non-existing cargo " + trackingId);
            return;
        }

        final Cargo cargo = cargoOptional.get();

        final HandlingHistory handlingHistory = handlingEventRepository.lookupHandlingHistoryOfCargo(trackingId);

        cargo.deriveDeliveryProgress(handlingHistory);

        if (cargo.delivery().isMisdirected()) {
            applicationEvents.cargoWasMisdirected(cargo);
        }

        if (cargo.delivery().isUnloadedAtDestination()) {
            applicationEvents.cargoHasArrived(cargo);
        }

        cargoRepository.store(cargo);
    }

}
