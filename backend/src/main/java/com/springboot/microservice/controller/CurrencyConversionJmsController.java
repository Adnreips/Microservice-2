package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.jms.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/currencyconversion")
@RestController
public class CurrencyConversionJmsController {

    private Sender sender;

    @Value("${my.jms.queue}")
    private String queueName;

    @Value("${my.jms.queue.object}")
    private String queueNameObject;

    public CurrencyConversionJmsController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping(value = "retrieve", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CurrencyConversionDto sendToForexService(@RequestBody CurrencyConversionDto message) {

        sender.sendMessageObject(queueName, message);

        return message;
    }

}

