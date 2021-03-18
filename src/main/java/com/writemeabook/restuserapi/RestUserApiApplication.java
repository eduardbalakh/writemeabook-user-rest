package com.writemeabook.restuserapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUserApiApplication.class, args);
    }

}
