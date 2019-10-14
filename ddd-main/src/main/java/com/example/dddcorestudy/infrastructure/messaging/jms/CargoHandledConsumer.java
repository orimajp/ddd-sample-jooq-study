package com.example.dddcorestudy.infrastructure.messaging.jms;

import com.example.dddcorestudy.application.service.CargoInspectionService;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class CargoHandledConsumer implements MessageListener {

    private final CargoInspectionService cargoInspectionService;

    /**
     * Passes a message to the listener.
     *
     * @param message the message passed to the listener
     */
    @Override
    public void onMessage(Message message) {
        try {
            final TextMessage textMessage = (TextMessage) message;
            final String trackingidString = textMessage.getText();

            cargoInspectionService.inspectCargo(new TrackingId(trackingidString));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
