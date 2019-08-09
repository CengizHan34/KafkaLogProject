package com.kafka.log.KafkaLogProject.consumer;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.entitys.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by Cengiz HAN
 */
@Service
public class Receiver {
    @Autowired
    private Gson gson;

    @KafkaListener(topics = "${app.topic.log}", groupId = "${app.group.id}")
    public void listen(String data) {
        Log log = gson.fromJson(data, Log.class);
        System.out.println("received message=" + log.toString());
    }
}