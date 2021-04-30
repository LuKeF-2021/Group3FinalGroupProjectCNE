package com.qa.ticketcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TicketCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketCloudGatewayApplication.class, args);
    }

}
