package com.dnr.apiservice;

import com.dnr.apiservice.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDate;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})

//@EnableTransactionManagement
public class ApiserviceApplication {

//    @Autowired
//    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(ApiserviceApplication.class, args);
    }

//    @PostConstruct
//    public void setUp() {
//        objectMapper.registerModule(new JavaTimeModule());
//    }

}
