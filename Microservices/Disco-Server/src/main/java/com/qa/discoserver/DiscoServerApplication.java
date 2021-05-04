package com.qa.discoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoServerApplication.class, args);
    }

}
