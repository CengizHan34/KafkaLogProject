package com.kafka.log.KafkaLogProject.service.init;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;

import static com.kafka.log.KafkaLogProject.util.RandomUtil.getRandomNumberInRange;

/**
 * Created by Cengiz HAN
 */
@Service
public class InitService {

    @PostConstruct
    @Async
    public void init() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            Log log = Log.builder()
                    .createLogDate(new Timestamp(System.currentTimeMillis()))
                    .logLevelType(LogLevelType.valueOf(getLogLevel()))
                    .cityName(CityName.valueOf(getCity()))
                    .logDetail("detail").build();
            System.out.println(log.toString());
        }
    }

    private String getCity() {
        return CityName.All.getCity(getRandomNumberInRange(5));
    }

    private String getLogLevel() {
        return LogLevelType.All.getLogLevel(getRandomNumberInRange(5));
    }
}
