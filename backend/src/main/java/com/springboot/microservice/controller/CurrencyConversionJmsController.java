package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.jms.Sender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api("Get currency conversion from async request")
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

    @ApiOperation("Send request to broker ActiveMq ")
    @GetMapping(value = "jms", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CurrencyConversionDto sendToForexService(@RequestBody CurrencyConversionDto message) {
        sender.sendMessageObject(queueNameObject, message);
        return message;
    }


}



