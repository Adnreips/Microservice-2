package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.feign.CurrencyExchangeProxy;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Get currency conversion from feign response")
@RestController
@RequestMapping("/currencyconversion")
@Slf4j
public class CurrencyConversionFeignController {

    private final CurrencyExchangeProxy proxy;

    @Autowired
    public CurrencyConversionFeignController(CurrencyExchangeProxy proxy) {
        this.proxy = proxy;
    }

    @PostMapping(value = "/feign")
    public CurrencyConversionDto convertCurrencyFeign(@RequestBody CurrencyConversionDto currencyConversionDto) {
        CurrencyConversionDto response = proxy.retrieveExchangeValue(currencyConversionDto);
        log.info("{}", response.getConversionMultiple());
        return response;
    }
}
