package com.qa.readallticketsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ReadAllTicketsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadAllTicketsServiceApplication.class, args);
    }

}
