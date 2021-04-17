package com.springboot.microservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Service
@NoArgsConstructor
@Document
public class CurrencyConversion {

    @Id()
    private String id;
    @NotBlank(message = "from is mandatory")
    private String from;
    @NotBlank(message = "to is mandatory")
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal multiply;
    private int port;
    private LocalDateTime timeStamp;



}
