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

    private  CurrencyConversionDtoClient currencyConversionDtoClient;

    private CurrencyConversionDto currencyConversionDto;

    @Autowired
    public ClientLiveTest(CurrencyConversionDtoClient currencyConversionDtoClient) {
        this.currencyConversionDtoClient = currencyConversionDtoClient;
    }

    @BeforeEach
    public void setUp() {
        currencyConversionDto = new CurrencyConversionDto();
        currencyConversionDto.setId(1L);
        currencyConversionDto.setFrom("USD");
        currencyConversionDto.setTo("INR");
        currencyConversionDto.setConversionMultiple(new BigDecimal("1"));
        currencyConversionDto.setQuantity(new BigDecimal("1"));
        currencyConversionDto.setMultiply(new BigDecimal("0"));
        currencyConversionDto.setPort(1);
    }

    @Test
    void givenCurrencyConversionDto() {
        GetCurrencyConversionDtoResponse response = currencyConversionDtoClient.getCurrencyConversionDto(currencyConversionDto);
        assertEquals(new BigDecimal("65.00"), response.getCurrencyConversionDto().getConversionMultiple());

    }
}