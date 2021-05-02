package com.springboot.microservice.rest.service;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class RestTemplateService {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyConversionDto getCurrencyConversion(CurrencyConversionDto currencyConversionDto) {
        log.debug("Начали c DTO: {}", currencyConversionDto);

        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        CurrencyConversionDto result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieve", requestBody, CurrencyConversionDto.class).getBody();

        log.debug("Закончили c ответом: {}", result);
        return result;
    }

    @Async
    public void getCurrencyConversionAsync(CurrencyConversionDto currencyConversionDto) {
        log.debug("Начали c DTO: {}", currencyConversionDto);

        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        ResponseEntity<CurrencyConversionDto> result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieveasyncrequest", requestBody, CurrencyConversionDto.class);

        log.debug("Закончили c ответом: {}", result);
    }
}
