package com.kafka.log.KafkaLogProject.service;

import com.kafka.log.KafkaLogProject.entitys.Log;

import java.util.Collection;

/**
 * Created by Cengiz HAN
 */
public interface LogService {
    Log save(final Log log);

    Log get(final Long id);

    Collection<Log> getAll();

}
