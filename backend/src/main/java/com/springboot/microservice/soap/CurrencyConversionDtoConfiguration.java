package com.springboot.microservice.soap;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CurrencyConversionDtoConfiguration {


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.springboot.microservice");
        return marshaller;
    }

    @Bean
    public CurrencyConversionDtoClient currencyConversionDtoClient(Jaxb2Marshaller marshaller) {
        CurrencyConversionDtoClient client = new CurrencyConversionDtoClient();
        client.setDefaultUri("http://localhost:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
