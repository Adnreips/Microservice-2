package com.springboot.microservice.jms;


import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyMessageListener extends MessageListener{
    @Override
    public void receiveMessage2(CurrencyConversionDto message) {
        super.receiveMessage2(message);
        log.info("Received message, conversionMultiple = {}", message.getConversionMultiple());

    }
}
