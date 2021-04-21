package com.springboot.microservice.transfer;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.entity.CurrencyConversion;
import lombok.Data;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

@Service
@Data
public class CurrencyConversionFromDto {

    public CurrencyConversion from(CurrencyConversionDto currencyConversionDto){

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CurrencyConversionDto.class, CurrencyConversion.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        CurrencyConversion currencyConversion;
        currencyConversion = mapper.map(currencyConversionDto, CurrencyConversion.class);
        return currencyConversion;
    }

}
