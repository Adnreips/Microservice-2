package com.springboot.microservice.dto;

import com.springboot.microservice.CurrencyConversionDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;



class TestDtoTest {



    @Test
    void getConversionMultiple() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CurrencyConversionDto.class, TestDto.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        CurrencyConversionDto src = new CurrencyConversionDto(1L, "RUB", "USD", new BigDecimal("75"), new BigDecimal("1"),  new BigDecimal("75"),1);
        TestDto dest;
        dest = mapper.map(src, TestDto.class);
        assertEquals(dest.getFrom(), src.getFrom());
        assertEquals(dest.getMultiply(), src.getMultiply());

    }
}