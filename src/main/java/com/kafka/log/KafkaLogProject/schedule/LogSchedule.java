package com.kafka.log.KafkaLogProject.schedule;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Cengiz HAN
 */
@Component
public class LogSchedule {

    @Autowired
    private Sender sender;

    @Autowired
    private Gson gson;

    @Scheduled(fixedRate = 1000)
    public void sendToKafka() {
        Log log = Log.builder().logDetail("adssadsad").build();
        sender.send(gson.toJson(log));
    }
}
