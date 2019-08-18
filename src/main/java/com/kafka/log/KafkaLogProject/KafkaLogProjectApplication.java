package com.kafka.log.KafkaLogProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaLogProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaLogProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
