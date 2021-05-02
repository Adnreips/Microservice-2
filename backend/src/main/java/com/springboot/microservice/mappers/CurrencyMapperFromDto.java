package com.springboot.microservice.mappers;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.entity.CurrencyConversion;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyMapperFromDto {

    private final MapperFacade mapperFacade;

    @Autowired
    public CurrencyMapperFromDto(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public CurrencyConversion from(CurrencyConversionDto currencyConversionDto) {
        return mapperFacade.map(currencyConversionDto, CurrencyConversion.class);
    }

}
