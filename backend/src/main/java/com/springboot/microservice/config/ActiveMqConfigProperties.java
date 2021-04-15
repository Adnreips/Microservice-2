package com.springboot.microservice.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "broker")
public class ActiveMqConfigProperties {

    private String brokerUrl;

    private String userName;

    private String password;

    private String queueName;


}