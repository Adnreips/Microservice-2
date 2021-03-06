package com.springboot.microservice.soap;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.GetCurrencyConversionDtoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientLiveTest {

    private final CurrencyConversionDtoClient currencyConversionDtoClient;

    private CurrencyConversionDto currencyConversionDto;

    @Autowired
    public ClientLiveTest(CurrencyConversionDtoClient currencyConversionDtoClient) {
        this.currencyConversionDtoClient = currencyConversionDtoClient;
    }

    @BeforeEach
    public void setUp() {
        currencyConversionDto = new CurrencyConversionDto();
        currencyConversionDto.setId(1L);
        currencyConversionDto.setFrom("EUR");
        currencyConversionDto.setTo("RUB");
        currencyConversionDto.setConversionMultiple(new BigDecimal("1"));
        currencyConversionDto.setQuantity(new BigDecimal("1"));
        currencyConversionDto.setMultiply(new BigDecimal("0"));
        currencyConversionDto.setPort(1);
    }

    @Test
    void givenCurrencyConversionDto() {
        GetCurrencyConversionDtoResponse actualResponse = currencyConversionDtoClient.getCurrencyConversionDto(currencyConversionDto);

        BigDecimal expectedConversionMultiple = new BigDecimal("85.00");
        assertEquals(expectedConversionMultiple, actualResponse.getCurrencyConversionDto().getConversionMultiple());
    }
}