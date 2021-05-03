package com.springboot.microservice.soap;


import com.springboot.microservice.CurrencyConversionDto;
import com.springboot.microservice.GetCurrencyConversionDtoRequest;
import com.springboot.microservice.GetCurrencyConversionDtoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


@Slf4j
public class CurrencyConversionDtoClient extends WebServiceGatewaySupport {


    public GetCurrencyConversionDtoResponse getCurrencyConversionDto(CurrencyConversionDto currencyConversionDto) {
        GetCurrencyConversionDtoRequest request = new GetCurrencyConversionDtoRequest();
        request.setCurrencyConversionDto(currencyConversionDto);
        return (GetCurrencyConversionDtoResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8081/ws/currencyconversiondtos",
                request,
                new SoapActionCallback("http://springboot.com/microservice/GetCurrencyConversionDtoRequest"));
    }

}
