package com.kafka.log.KafkaLogProject.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Cengiz HAN
 */
@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.log}")
    private String topic;

    public void send(String data) {
//            Map<String, Object> headers = new HashMap<>();
//            headers.put(KafkaHeaders.TOPIC, topic);
//            Message<LogDto> message = MessageBuilder.withPayload(logDto)
//                    .setHeader(KafkaHeaders.TOPIC, topic).build();
        kafkaTemplate.send(topic, data);
    }
}
