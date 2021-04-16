package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.rest.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController
@RequestMapping("/currencyconversion")
@Slf4j
public class CurrencyConversionRestController {


    RestTemplateService restTemplateService;

    public CurrencyConversionRestController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping(value = "/rest", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto convertCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {

        CurrencyConversionDto currencyConversionDto1 = restTemplateService.getCurrencyConversion(currencyConversionDto).getBody();

        return currencyConversionDto1;
    }

    @GetMapping(value = "/restasync", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto convertAsyncCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {

        currencyConversionDto.setId(new Random().nextLong());

        restTemplateService.beginAsyncCurrencyConversion(currencyConversionDto);

        return currencyConversionDto;

    }

    @PostMapping(value = "/retrieveasyncresponse", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto getExchangeValueAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {

        log.info("Exchange value: {}", currencyConversionDto);


        return currencyConversionDto;

    }






}
