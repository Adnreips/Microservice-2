package com.springboot.microservice.config;

import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.entity.CurrencyConversion;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MapperConfig
 *
 * @author "Andrei Prokofiev"
 */
@Configuration
public class MapperConfig {

    @Bean
    public MapperFactory mapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(CurrencyConversionDto.class, CurrencyConversion.class);
        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade(MapperFactory mapperFactory) {
        return mapperFactory.getMapperFacade();
    }
}
