package com.dnr.apiservice;

import com.dnr.apiservice.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ApiserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiserviceApplication.class, args);
    }

}
