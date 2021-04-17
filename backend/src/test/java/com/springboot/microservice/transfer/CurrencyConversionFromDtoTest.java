package com.springboot.microservice.transfer;

import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.model.CurrencyConversion;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionFromDtoTest {

    @Test
    void fromTest() {
        CurrencyConversion expectedCurrencyConversion;
        CurrencyConversionDto actualCurrencyConversionDto;
        actualCurrencyConversionDto = new CurrencyConversionDto(1L, "RUB", "USD", new BigDecimal("75"), new BigDecimal("1"), new BigDecimal("75"), 1);
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CurrencyConversionDto.class, CurrencyConversion.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        expectedCurrencyConversion = mapper.map(actualCurrencyConversionDto, CurrencyConversion.class);
        assertEquals(actualCurrencyConversionDto.getConversionMultiple(), expectedCurrencyConversion.getConversionMultiple());
        assertEquals(actualCurrencyConversionDto.getFrom(), expectedCurrencyConversion.getFrom());
    }
}