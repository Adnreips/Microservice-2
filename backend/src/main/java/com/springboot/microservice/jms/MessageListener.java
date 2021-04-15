package com.springboot.microservice.jms;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MessageListener {

    @JmsListener(destination = "${me.jms.queue.object}")
    public void receiveMessage2(CurrencyConversionDto message) {
        log.info("Received message {}", message);
    }
}