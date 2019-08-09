package com.kafka.log.KafkaLogProject.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Cengiz HAN
 */
@Service
public class Sender {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.log}")
    private String topic = "log.t";

    public void send(String data) {
//            Map<String, Object> headers = new HashMap<>();
//            headers.put(KafkaHeaders.TOPIC, topic);
//            Message<LogDto> message = MessageBuilder.withPayload(logDto)
//                    .setHeader(KafkaHeaders.TOPIC, topic).build();
        kafkaTemplate.send(topic, data);
    }
}
