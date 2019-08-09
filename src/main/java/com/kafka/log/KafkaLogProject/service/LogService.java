package com.kafka.log.KafkaLogProject.service;

import com.kafka.log.KafkaLogProject.entitys.Log;

import java.util.Collection;

/**
 * Created by Cengiz HAN
 */
public interface LogService {
    /**
     * @param log
     * @return
     */
    Log save(final Log log);

    /**
     * @param id
     * @return
     */

    Log get(final Long id);

    /**
     * @return
     */

    Collection<Log> getAll();

    /**
     * @return
     */

    String publish();

}
