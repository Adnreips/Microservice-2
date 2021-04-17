package com.springboot.microservice.service;


import com.springboot.microservice.CurrencyConversionDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionDtoService {

    public Boolean valid (CurrencyConversionDto currencyConversionDto){

        if (currencyConversionDto.getFrom()==null || currencyConversionDto.getTo()==null){
            return false;
        }

        return true;

    }
}
