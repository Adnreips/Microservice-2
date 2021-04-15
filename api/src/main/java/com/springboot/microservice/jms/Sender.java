package com.springboot.microservice.jms;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender {

    private JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageObject(final String queueName, final Object message) {
        log.info("Sending message {} to queue - {}", message, queueName);
        jmsTemplate.setTimeToLive(30000);
        jmsTemplate.convertAndSend(queueName, message);
    }
}

