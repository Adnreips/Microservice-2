package com.springboot.microservice.rest.service;

import com.springboot.microservice.CurrencyConversionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
        log.info("Отправка запроса к forex с DTO : {}", currencyConversionDto);

        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        CurrencyConversionDto result = restTemplate.postForEntity(
                "http://localhost:8000/exchangevalue/retrieve",
                requestBody,
                CurrencyConversionDto.class).getBody();

        log.info("Получен ответ от forex с DTO: {}", result);
        return result;
    }

    public ResponseEntity<String> getCurrencyConversionAsync(CurrencyConversionDto currencyConversionDto) {
        log.info("Отправка запроса к forex с DTO: {}", currencyConversionDto);

        HttpEntity<CurrencyConversionDto> requestBody = new HttpEntity<>(currencyConversionDto);
        ResponseEntity<String> result = restTemplate.postForEntity(
                "http://localhost:8000/exchangevalue/retrieveasyncrequest",
                requestBody,
                String.class);

        log.info("Получен ответ от forex с DTO: {}", result);
        return result;
    }
}
