package com.springboot.microservice.mappers;

import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.config.MapperConfig;
import com.springboot.microservice.entity.CurrencyConversion;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyMapperFromDtoTest {

    private CurrencyMapperFromDto currencyConversionFromDto;
    private CurrencyConversionDto actualCurrencyConversionDto;
    private MapperFacade mapperFacade;
    private MapperConfig mapperConfig;
    private MapperFactory mapperFactory;

    @BeforeEach
    public void setUp() {
        mapperConfig = new MapperConfig();
        mapperFacade = mapperConfig.mapperFacade(mapperConfig.mapperFactory());
        currencyConversionFromDto = new CurrencyMapperFromDto(mapperFacade);
        actualCurrencyConversionDto = new CurrencyConversionDto();
        actualCurrencyConversionDto.setId(1L);
        actualCurrencyConversionDto.setFrom("USD");
        actualCurrencyConversionDto.setTo("INR");
        actualCurrencyConversionDto.setConversionMultiple(new BigDecimal("1"));
        actualCurrencyConversionDto.setQuantity(new BigDecimal("1"));
        actualCurrencyConversionDto.setMultiply(new BigDecimal("65"));
        actualCurrencyConversionDto.setPort(1);
    }

    @Test
    void fromTest() {
        CurrencyConversion expectedCurrencyConversion;
        expectedCurrencyConversion = currencyConversionFromDto.from(actualCurrencyConversionDto);

        assertEquals(actualCurrencyConversionDto.getConversionMultiple(), expectedCurrencyConversion.getConversionMultiple());
        assertEquals(actualCurrencyConversionDto.getFrom(), expectedCurrencyConversion.getFrom());
    }
}