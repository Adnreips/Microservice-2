package com.springboot.microservice.repository;

import com.springboot.microservice.entity.CurrencyConversion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CurrencyConversionRepository extends MongoRepository<CurrencyConversion, Long> {
    @Override
    <S extends CurrencyConversion> S insert(S s);

    public Optional<CurrencyConversion> findById(Long Id);

    public List<CurrencyConversion> findAllByFromAndTo(String from, String to);





}
