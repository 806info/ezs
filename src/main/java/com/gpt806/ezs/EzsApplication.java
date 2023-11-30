package com.gpt806.ezs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EzsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzsApplication.class, args);
    }

}
