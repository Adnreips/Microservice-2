package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.jms.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/currencyconversion")
@RestController
@Slf4j
public class CurrencyConversionJmsController {

    private Sender sender;

    @Value("${se.jms.queue.object}")
    private String queueNameObject;

    public CurrencyConversionJmsController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping(value = "jms", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CurrencyConversionDto sendToForexService(@RequestBody CurrencyConversionDto message) {


        sender.sendMessageObject(queueNameObject, message);


        return message;
    }



}



