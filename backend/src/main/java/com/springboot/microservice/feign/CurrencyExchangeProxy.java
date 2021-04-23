package com.springboot.microservice.feign;


import com.springboot.microservice.CurrencyConversionDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeProxy {

    @PostMapping("/exchangevalue/retrieve")
    public CurrencyConversionDto retrieveExchangeValue
            (@RequestBody CurrencyConversionDto currencyConversionDto);

}
