package com.kafka.log.KafkaLogProject.service.init;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.kafka.log.KafkaLogProject.util.RandomUtil.getRandomNumberInRange;

/**
 * Created by Cengiz HAN
 */
@Service
public class InitService implements Runnable {
    private static String URL = "http://localhost:8080/api/log";

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            while (true) {
                Thread.sleep(2000);
                Log log = Log.builder()
                        .createLogDate(new Timestamp(System.currentTimeMillis()))
                        .logLevelType(LogLevelType.valueOf(getLogLevel()))
                        .cityName(CityName.valueOf(getCity()))
                        .logDetail("detail").build();
                System.out.println(Thread.currentThread().getId() + " " + log.toString());

                Client client = Client.create();
                WebResource resource = client.resource(URL);

                Log savedLog = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .post(Log.class, log);

                System.err.println(savedLog.toString());
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught" + e.getMessage());
        }
    }

    @PostConstruct
    @Async
    public void init() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable initServiceThread_1 = new InitService();
        executor.execute(initServiceThread_1);
    }

    private String getCity() {
        return CityName.All.getCity(getRandomNumberInRange(5));
    }

    private String getLogLevel() {
        return LogLevelType.All.getLogLevel(getRandomNumberInRange(5));
    }
}
