package com.qa.readticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReadTicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadTicketServiceApplication.class, args);
    }

}
