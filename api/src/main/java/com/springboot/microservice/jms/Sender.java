package com.springboot.microservice.jms;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Sender {
    private JmsTemplate jmsTemplate;

    @Value("${spring.application.name}")
    private String nameOfApplication;

    @Autowired
    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageObject(final String queueName, final Object message) {
        log.info("Sending message {} to queue - {}", message, queueName);
        jmsTemplate.setTimeToLive(30000);
        jmsTemplate.convertAndSend(queueName, message,
                m -> {
                    m.setStringProperty("nameOfApplication", nameOfApplication);
                    return m;
                }
        );


    }
}

