package com.springboot.microservice.jms;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessageListener {

    @JmsListener(destination = "${me.jms.queue.object}")
    public void receiveMessage2(CurrencyConversionDto message, MessageHeaders messageHeaders) {
        log.info("Received message, conversionMultiple = {}, nameOfApplication: {}", message.getConversionMultiple()
        ,messageHeaders.get("nameOfApplication"));

    }

}