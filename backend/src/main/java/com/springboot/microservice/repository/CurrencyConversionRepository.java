package com.springboot.microservice.repository;

import com.springboot.microservice.entity.CurrencyConversion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyConversionRepository extends MongoRepository<CurrencyConversion, Long> {

    @Override
    <S extends CurrencyConversion> S insert(S entity);

}
