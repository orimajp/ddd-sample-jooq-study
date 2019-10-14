package com.example.dddcorestudy.infrastructure.messaging.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
@Component
public class SimpleLoggingConsumer implements MessageListener {
    /**
     * Passes a message to the listener.
     *
     * @param message the message passed to the listener
     */
    @Override
    public void onMessage(Message message) {
        log.debug("Received JMS message: {}", message);
    }

}
