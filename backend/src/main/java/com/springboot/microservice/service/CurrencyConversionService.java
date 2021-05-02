package com.springboot.microservice.service;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.entity.CurrencyConversion;
import com.springboot.microservice.repository.CurrencyConversionRepository;
import com.springboot.microservice.mappers.CurrencyMapperFromDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrencyConversionService {
    private final CurrencyConversionRepository currencyConversionRepository;
    private final CurrencyMapperFromDto currencyConversionFromDto;


    public CurrencyConversionService(CurrencyConversionRepository currencyConversionRepository, CurrencyMapperFromDto currencyConversionFromDto) {
        this.currencyConversionRepository = currencyConversionRepository;
        this.currencyConversionFromDto = currencyConversionFromDto;
    }

    public void saveToDataBase(CurrencyConversionDto currencyConversionDto) {

        CurrencyConversion currencyConversion = currencyConversionFromDto.from(currencyConversionDto);
        currencyConversionRepository.insert(currencyConversion);
    }
}
