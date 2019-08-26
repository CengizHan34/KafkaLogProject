package com.kafka.log.KafkaLogProject.schedule;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.producer.Sender;
import com.kafka.log.KafkaLogProject.service.impl.RandomLogGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Cengiz HAN
 */
@Component
public class LogSchedule {
    private Sender sender;
    private Gson gson;

    @Autowired
    public LogSchedule(Sender sender, Gson gson) {
        this.sender = sender;
        this.gson = gson;
    }

    @Scheduled(fixedRate = 1000)
    public void sendToKafka() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable randomLogGenerator = new RandomLogGeneratorServiceImpl(sender, gson);
        executor.execute(randomLogGenerator);
    }
}
