package com.spire.platform.u20201e843;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PracticeEbSpireApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeEbSpireApplication.class, args);
    }

}
