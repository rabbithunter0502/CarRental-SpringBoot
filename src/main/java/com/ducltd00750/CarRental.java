package com.ducltd00750;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.ducltd00750", "it.ozimov.springboot"})
@EnableAsync
public class CarRental implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(CarRental.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
    }
}
