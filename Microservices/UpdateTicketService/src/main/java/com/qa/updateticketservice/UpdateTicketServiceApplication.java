package com.qa.updateticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UpdateTicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdateTicketServiceApplication.class, args);
    }

}
