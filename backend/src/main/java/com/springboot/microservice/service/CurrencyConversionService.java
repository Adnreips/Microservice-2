package com.springboot.microservice.service;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.model.CurrencyConversion;
import com.springboot.microservice.repository.CurrencyConversionRepository;
import com.springboot.microservice.transfer.CurrencyConversionFromDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrencyConversionService {
    private final CurrencyConversionRepository currencyConversionRepository;
    private final CurrencyConversionFromDto currencyConversionFromDto;


    public CurrencyConversionService(CurrencyConversionRepository currencyConversionRepository, CurrencyConversionFromDto currencyConversionFromDto) {
        this.currencyConversionRepository = currencyConversionRepository;
        this.currencyConversionFromDto = currencyConversionFromDto;
    }

    public void saveToDataBase(CurrencyConversionDto currencyConversionDto) {

        CurrencyConversion currencyConversion = currencyConversionFromDto.from(currencyConversionDto);
        currencyConversion.setTimeStamp(LocalDateTime.now());
        currencyConversionRepository.insert(currencyConversion);

    }
}
