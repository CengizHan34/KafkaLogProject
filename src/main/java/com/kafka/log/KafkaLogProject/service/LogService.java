package com.kafka.log.KafkaLogProject.service;

import com.kafka.log.KafkaLogProject.entitys.Log;

/**
 * Created by Cengiz HAN
 */
public interface LogService {
    /**
     * This method save the log object.
     *
     * @param log the log object
     * @return saved log object
     */
    Log save(final Log log);
}
