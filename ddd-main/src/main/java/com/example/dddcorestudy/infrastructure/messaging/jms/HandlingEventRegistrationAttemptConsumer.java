package com.example.dddcorestudy.infrastructure.messaging.jms;

import com.example.dddcorestudy.application.service.HandlingEventService;
import com.example.dddcorestudy.application.service.dto.handling.HandlingEventRegistrationAttempt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class HandlingEventRegistrationAttemptConsumer implements MessageListener {

    private final HandlingEventService handlingEventService;

    /**
     * Passes a message to the listener.
     *
     * @param message the message passed to the listener
     */
    @Override
    public void onMessage(final Message message) {
        try {
            final ObjectMessage om = (ObjectMessage) message;
            HandlingEventRegistrationAttempt attempt = (HandlingEventRegistrationAttempt) om.getObject();
            handlingEventService.registerHandlingEvent(
                    attempt.getCompletionTime(),
                    attempt.getTrackingId(),
                    attempt.getVoyageNumber(),
                    attempt.getUnLocode(),
                    attempt.getType()
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
