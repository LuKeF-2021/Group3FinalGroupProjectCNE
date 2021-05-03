package com.qa.ticketgateway.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

@Configuration
public class Config {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public RestTemplateBuilder restTemplateBuilder() {
//
//        RestTemplateBuilder rtb = mock(RestTemplateBuilder.class);
//        RestTemplate restTemplate = mock(RestTemplate.class);
//
//        when(rtb.build()).thenReturn(restTemplate);
//        return rtb;
//    }

}
