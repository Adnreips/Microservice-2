package com.springboot.microservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@Service
@NoArgsConstructor
@Component
//Добавить сщности request, response
public class CurrencyConversion {

    private UUID id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal multiply;
    private int port;

}
