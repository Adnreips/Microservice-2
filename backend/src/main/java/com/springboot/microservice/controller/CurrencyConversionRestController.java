package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.repository.CurrencyConversionRepository;
import com.springboot.microservice.rest.service.RestTemplateService;
import com.springboot.microservice.service.CurrencyConversionService;
import com.springboot.microservice.mappers.CurrencyMapperFromDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@Api("Get currency conversion from resttemplate response")
@RestController
@RequestMapping("/currencyconversion")
@Slf4j
public class CurrencyConversionRestController {

    private final RestTemplateService restTemplateService;
    private final CurrencyConversionService currencyConversionService;
    private final Random random = new Random();

    @Autowired
    public CurrencyConversionRestController(RestTemplateService restTemplateService, CurrencyConversionRepository currencyConversionRepository, CurrencyConversionService currencyConversionService, CurrencyMapperFromDto currencyConversionFromDto) {
        this.restTemplateService = restTemplateService;
        this.currencyConversionService = currencyConversionService;
    }

    @ApiOperation("Send request sync")
    @PostMapping(value = "/rest")
    public ResponseEntity<CurrencyConversionDto> convertCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {
        CurrencyConversionDto currencyConversionDtoResult = restTemplateService.getCurrencyConversion(currencyConversionDto);
        currencyConversionService.saveToDataBase(currencyConversionDtoResult);
        return ResponseEntity.ok().body(currencyConversionDtoResult);
    }


    @ApiOperation("Send request async")
    @PostMapping(value = "/restasync")
    public ResponseEntity<String> convertCurrencyAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {
        currencyConversionDto.setId(random.nextLong());
        return restTemplateService.getCurrencyConversionAsync(currencyConversionDto);
    }

    @ApiOperation("Get response async")
    @PostMapping(value = "/retrieveasyncresponse")
    public ResponseEntity<String> getExchangeValueAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {
        log.info("Получен post-запрос c CurrencyConversionDto: {}", currencyConversionDto.getConversionMultiple());
        currencyConversionService.saveToDataBase(currencyConversionDto);
        return ResponseEntity.ok().body("Ok");
    }

}
