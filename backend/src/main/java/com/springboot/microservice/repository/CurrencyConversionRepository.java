package com.springboot.microservice.repository;

import com.springboot.microservice.model.CurrencyConversion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CurrencyConversionRepository extends MongoRepository<CurrencyConversion, Long> {
    @Override
    <S extends CurrencyConversion> S insert(S s);

    public CurrencyConversion findCurrencyConversionById(Long Id);
    public List<CurrencyConversion> findAllByFromAndTo(String from, String to);





}
