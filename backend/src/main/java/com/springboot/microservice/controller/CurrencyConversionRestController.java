package com.springboot.microservice.controller;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.repository.CurrencyConversionRepository;
import com.springboot.microservice.rest.service.RestTemplateService;
import com.springboot.microservice.service.CurrencyConversionDtoService;
import com.springboot.microservice.service.CurrencyConversionService;
import com.springboot.microservice.transfer.CurrencyConversionFromDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController
@RequestMapping("/currencyconversion")
@Slf4j
public class CurrencyConversionRestController {

    private final RestTemplateService restTemplateService;

    private final CurrencyConversionService currencyConversionService;

    private final CurrencyConversionDtoService currencyConversionDtoService;


    @Autowired
    public CurrencyConversionRestController(RestTemplateService restTemplateService, CurrencyConversionRepository currencyConversionRepository, CurrencyConversionService currencyConversionService, CurrencyConversionFromDto currencyConversionFromDto, CurrencyConversionDtoService currencyConversionDtoService) {
        this.restTemplateService = restTemplateService;
        this.currencyConversionService = currencyConversionService;
        this.currencyConversionDtoService = currencyConversionDtoService;
    }

    @PostMapping(value = "/rest", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CurrencyConversionDto> convertCurrency(@RequestBody CurrencyConversionDto currencyConversionDto) {

        if (currencyConversionDtoService.valid(currencyConversionDto)) {
            CurrencyConversionDto currencyConversionDto1 = restTemplateService.getCurrencyConversion(currencyConversionDto);
            currencyConversionService.saveToDataBase(currencyConversionDto1);
            return ResponseEntity.ok().body(currencyConversionDto1);
        }
        return ResponseEntity.badRequest().body(currencyConversionDto);
    }

    @PostMapping(value = "/restasync", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CurrencyConversionDto convertCurrencyAsync(@RequestBody CurrencyConversionDto currencyConversionDto) {

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
