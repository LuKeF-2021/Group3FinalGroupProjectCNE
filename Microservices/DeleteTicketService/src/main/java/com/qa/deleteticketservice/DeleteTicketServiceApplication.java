package com.qa.deleteticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeleteTicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeleteTicketServiceApplication.class, args);
    }

}
