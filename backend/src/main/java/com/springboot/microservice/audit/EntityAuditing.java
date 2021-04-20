package com.springboot.microservice.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityAuditing implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        String name = "Andrei";
        Optional<String> optional = Optional.of(name);

        return optional;
    }
}
