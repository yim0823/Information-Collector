package com.bespinglobal.dcos.ic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ICApplication {

    public static void main(String[] args) {
        SpringApplication.run(ICApplication.class, args);
    }
}
