package com.springboot.microservice.transfer;

import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.entity.CurrencyConversion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyConversionFromDtoTest {

    private CurrencyConversionFromDto currencyConversionFromDto;
    private CurrencyConversionDto actualCurrencyConversionDto;

    @BeforeEach
    public void setUp() {
        currencyConversionFromDto = new CurrencyConversionFromDto();
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