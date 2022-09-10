package com.zerowaste.gangdongbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GangdongBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GangdongBackendApplication.class, args);
    }

}
