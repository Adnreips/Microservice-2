package com.springboot.microservice.rest.service;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Data
@Service
@Slf4j
public class RestTemplateService {

    public CurrencyConversionDto getCurrencyConversion(CurrencyConversionDto currencyConversionDto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        CurrencyConversionDto result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieve", requestBody, CurrencyConversionDto.class).getBody();
        return result;
    }

    @Async
    public void beginAsyncCurrencyConversion(CurrencyConversionDto currencyConversionDto) {
        log.info("Начали .....");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        ResponseEntity<CurrencyConversionDto> result
                = restTemplate.postForEntity("http://localhost:8000/exchangevalue/retrieveasyncrequest", requestBody, CurrencyConversionDto.class);
        log.info("Закончили .....");

    }
}
