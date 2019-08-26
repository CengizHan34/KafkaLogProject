package com.kafka.log.KafkaLogProject.service.impl;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.producer.Sender;
import com.kafka.log.KafkaLogProject.service.RandomLogGenerator;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.kafka.log.KafkaLogProject.util.RandomUtil.getRandomNumberInRange;

/**
 * Created by Cengiz HAN
 */
@Service
public class RandomLogGeneratorServiceImpl implements Runnable, RandomLogGenerator {
    private Sender sender;
    private Gson gson;

    public RandomLogGeneratorServiceImpl(Sender sender, Gson gson) {
        this.sender = sender;
        this.gson = gson;
    }

    @Override
    public void run() {
        try {
            Log log = Log.builder()
                    .createdDate(new Timestamp(System.currentTimeMillis()))
                    .levelType(LogLevelType.valueOf(getLogLevel()))
                    .cityName(CityName.valueOf(getCity()))
                    .detail("detail").build();
            sender.send(gson.toJson(log));

        } catch (Exception e) {
            System.out.println("Exception is caught" + e.getMessage());
        }
    }

    private String getCity() {
        return CityName.All.getCity(getRandomNumberInRange(5));
    }

    private String getLogLevel() {
        return LogLevelType.All.getLogLevel(getRandomNumberInRange(5));
    }
}
