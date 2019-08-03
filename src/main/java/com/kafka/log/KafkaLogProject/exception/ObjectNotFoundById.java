package com.kafka.log.KafkaLogProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cengiz HAN
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundById extends RuntimeException {
    public ObjectNotFoundById(String message) {
        super(message);
    }
}
