package com.springboot.microservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.feign.CurrencyExchangeServiceProxy;
import com.springboot.microservice.model.CurrencyConversion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/currencyconversion")
@Slf4j
public class CurrencyConversionRestController {

    private CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionRestController(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping(value = "/rest", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto convertCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        ResponseEntity<CurrencyConversionDto> result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieve", requestBody, CurrencyConversionDto.class);
        CurrencyConversionDto currencyConversionDto1 = result.getBody();

        return currencyConversionDto1;
    }


    @GetMapping(value = "/feign",  consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto convertCurrencyFeign(@RequestBody CurrencyConversionDto currencyConversionDto) {

        CurrencyConversionDto response = proxy.retrieveExchangeValue(currencyConversionDto);

        log.info("{}", response);

        return response;
    }
}
