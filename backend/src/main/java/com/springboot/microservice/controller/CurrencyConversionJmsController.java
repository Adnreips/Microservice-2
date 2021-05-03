package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.jms.Sender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Get currency conversion from async request")
@RequestMapping("/currencyconversion")
@RestController
@Slf4j
public class CurrencyConversionJmsController {

    private final Sender sender;

    @Value("${se.jms.queue.object}")
    private String queueNameObject;

    public CurrencyConversionJmsController(Sender sender) {
        this.sender = sender;
    }

    @ApiOperation("Send request to broker ActiveMq ")
    @GetMapping(value = "jms")
    public ResponseEntity<String> sendToForexService(@RequestBody CurrencyConversionDto message) {
        sender.sendMessageObject(queueNameObject, message);
        return ResponseEntity.ok("Ok");
    }


}



