package com.springboot.microservice.jms;


import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@Component
public class MessageListener {

    @JmsListener(destination = "${me.jms.queue.object}")
    public void receiveMessage2(CurrencyConversionDto message) {

        log.info("Received message {}", message);
    }


}