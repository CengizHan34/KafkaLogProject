package com.kafka.log.KafkaLogProject.consumer;

import com.google.gson.Gson;
import com.kafka.log.KafkaLogProject.dto.ReportDto;
import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.repository.LogDao;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cengiz HAN
 */
@Service
@NoArgsConstructor
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private SimpMessagingTemplate simpMessagingTemplate;
    private Gson gson;
    private LogDao logDao;

    private Map<String, ReportDto> cityLogCount = new HashMap<>();

    @Autowired
    public Receiver(SimpMessagingTemplate simpMessagingTemplate, Gson gson, LogDao logDao) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.gson = gson;
        this.logDao = logDao;
    }

    @KafkaListener(topics = "${app.topic.log}", groupId = "${app.group.id}")
    public void listen(String data) {
        int second = DateTime.now().getSecondOfMinute();
        Log log = gson.fromJson(data, Log.class);
        String city = log.getCityName().toString();

        if (!cityLogCount.containsKey(city)) {
            ReportDto reportDto = ReportDto.builder().x(log.getCreatedDate()).y(1l).build();
            cityLogCount.put(city, reportDto);

        } else {
            ReportDto reportDto = cityLogCount.get(city);
            reportDto.setY(reportDto.getY() + 1);

        }
        if (second % 30 == 0) {
            simpMessagingTemplate.convertAndSend("/topic/log", cityLogCount);
            cityLogCount = new HashMap<>();
        }
        Log dbLogObj = logDao.save(log);
        logger.info("İd :{}, Log successfully saved.", dbLogObj.getId());
    }
}