package com.kafka.log.KafkaLogProject;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.dto.LogDto;
import com.kafka.log.KafkaLogProject.producer.Sender;
import com.kafka.log.KafkaLogProject.service.init.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaLogProjectApplication implements CommandLineRunner {
    @Autowired
    private InitService initService;

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(KafkaLogProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        while (true) {
//            Thread.sleep(1000);
//            LogDto log = new LogDto();
//            log.setId(10l);
//            log.setDetail("asd");
//            Gson gson = new Gson();
//
//            sender.send(gson.toJson(log));
//        }
    }
}
