package com.springboot.microservice.entity;


import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Document
public class CurrencyConversion {

    private Long id;
    @Id
    private UUID uuid = UUID.randomUUID();
    @NotBlank(message = "from is mandatory")
    private String from;
    @NotBlank(message = "to is mandatory")
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal multiply;
    private int port;
    @CreatedDate
    private Date timestamp;
    @CreatedBy
    private String createdBy;
    @Version
    private Integer version;

}
