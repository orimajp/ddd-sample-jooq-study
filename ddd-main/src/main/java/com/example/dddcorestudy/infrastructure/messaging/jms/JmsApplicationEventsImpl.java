package com.example.dddcorestudy.infrastructure.messaging.jms;

import com.example.dddcorestudy.application.service.ApplicationEvents;
import com.example.dddcorestudy.application.service.dto.handling.HandlingEventRegistrationAttempt;
import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JmsApplicationEventsImpl implements ApplicationEvents {
    /**
     * A cargo has been handled.
     *
     * @param event handling event
     */
    @Override
    public void cargoWasHandled(HandlingEvent event) {

    }

    /**
     * A cargo has been misdirected.
     *
     * @param cargo cargo
     */
    @Override
    public void cargoWasMisdirected(Cargo cargo) {

    }

    /**
     * A cargo has arrived at its final destination.
     *
     * @param cargo cargo
     */
    @Override
    public void cargoHasArrived(Cargo cargo) {

    }

    /**
     * A handling event regitration attempt is received.
     *
     * @param attempt handling event registration attempt
     */
    @Override
    public void receivedHandlingEventRegistrationAttempt(HandlingEventRegistrationAttempt attempt) {

    }

}
