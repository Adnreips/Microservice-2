package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.repository.CurrencyConversionRepository;
import com.springboot.microservice.rest.service.RestTemplateService;
import com.springboot.microservice.service.CurrencyConversionService;
import com.springboot.microservice.transfer.CurrencyConversionFromDto;
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

    @Autowired
    public CurrencyConversionRestController(RestTemplateService restTemplateService, CurrencyConversionRepository currencyConversionRepository, CurrencyConversionService currencyConversionService, CurrencyConversionFromDto currencyConversionFromDto) {
        this.restTemplateService = restTemplateService;
        this.currencyConversionService = currencyConversionService;
    }

    @ApiOperation("Send request sync")
    @PostMapping(value = "/rest", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CurrencyConversionDto> convertCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {
            CurrencyConversionDto currencyConversionDtoResult = restTemplateService.getCurrencyConversion(currencyConversionDto);
            currencyConversionService.saveToDataBase(currencyConversionDtoResult);
        return ResponseEntity.ok().body(currencyConversionDtoResult);
    }

    @ApiOperation("Send request async")
    @PostMapping(value = "/restasync", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CurrencyConversionDto> convertCurrencyAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {
        currencyConversionDto.setId(new Random().nextLong());
        restTemplateService.beginAsyncCurrencyConversion(currencyConversionDto);
        return ResponseEntity.ok().body(currencyConversionDto);

    }

    @ApiOperation("Get response async")
    @PostMapping(value = "/retrieveasyncresponse", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CurrencyConversionDto> getExchangeValueAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {
        log.info("Exchange value: {}", currencyConversionDto.getConversionMultiple());
        currencyConversionService.saveToDataBase(currencyConversionDto);
        return ResponseEntity.ok().body(currencyConversionDto);
    }


}
