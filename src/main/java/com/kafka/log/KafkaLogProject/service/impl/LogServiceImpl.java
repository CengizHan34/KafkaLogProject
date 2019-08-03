package com.kafka.log.KafkaLogProject.service.impl;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.exception.ObjectNotFoundById;
import com.kafka.log.KafkaLogProject.repository.LogDao;
import com.kafka.log.KafkaLogProject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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

    @Override
    public Log get(Long id) {
        Optional<Log> optional = logDao.findById(id);
        if (!optional.isPresent()) {
            throw new ObjectNotFoundById("Log not found by ID: " + id);
        }
        Log log = optional.get();
        return log;
    }

    @Override
    public Collection<Log> getAll() {
        Collection<Log> all = logDao.findAll();
        return all;
    }
}
