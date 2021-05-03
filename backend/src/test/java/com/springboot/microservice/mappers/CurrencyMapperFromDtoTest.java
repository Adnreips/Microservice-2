package com.springboot.microservice.mappers;

import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.config.MapperConfig;
import com.springboot.microservice.entity.CurrencyConversion;
import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyMapperFromDtoTest {

    private CurrencyMapperFromDto currencyMapperFromDto;
    private CurrencyConversionDto currencyConversionDto;
    private CurrencyConversion expectedCurrencyConversion;

    @BeforeEach
    public void setUp() {
        MapperConfig mapperConfig = new MapperConfig();
        MapperFacade mapperFacade = mapperConfig.mapperFacade(mapperConfig.mapperFactory());

        currencyMapperFromDto = new CurrencyMapperFromDto(mapperFacade);

        currencyConversionDto = new CurrencyConversionDto();
        currencyConversionDto.setId(1L);
        currencyConversionDto.setFrom("USD");
        currencyConversionDto.setTo("INR");
        currencyConversionDto.setConversionMultiple(new BigDecimal("1"));
        currencyConversionDto.setQuantity(new BigDecimal("1"));
        currencyConversionDto.setMultiply(new BigDecimal("65"));
        currencyConversionDto.setPort(1);

        expectedCurrencyConversion = new CurrencyConversion();
        expectedCurrencyConversion.setId(1L);
        expectedCurrencyConversion.setFrom("USD");
        expectedCurrencyConversion.setTo("INR");
        expectedCurrencyConversion.setConversionMultiple(new BigDecimal("1"));
        expectedCurrencyConversion.setQuantity(new BigDecimal("1"));
        expectedCurrencyConversion.setMultiply(new BigDecimal("65"));
        expectedCurrencyConversion.setPort(1);
    }

    @Test
    void fromTest() {
        CurrencyConversion actualCurrencyConversion = currencyMapperFromDto.from(currencyConversionDto);
        assertEquals(expectedCurrencyConversion, actualCurrencyConversion);
    }
}