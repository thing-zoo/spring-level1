package com.example.springlevel1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringLevel1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringLevel1Application.class, args);
    }

}
