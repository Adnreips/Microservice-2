package com.springboot.microservice.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Document
@EqualsAndHashCode(exclude = {"uuid"})
public class CurrencyConversion {

    private Long id;

    @Id
    private UUID uuid = UUID.randomUUID();

    private String from;
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
