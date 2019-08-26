package com.kafka.log.KafkaLogProject.service.impl;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.repository.LogDao;
import com.kafka.log.KafkaLogProject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cengiz HAN
 */
@Service
public class LogServiceImpl implements LogService {
    private LogDao logDao;

    @Autowired
    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public Log save(Log log) {
        Log saved = logDao.save(log);
        return saved;
    }
}
