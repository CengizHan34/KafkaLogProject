package com.kafka.log.KafkaLogProject.controller;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cengiz HAN
 */
@RestController
@RequestMapping(value = {"/api/log"})
public class LogController {
    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<Log> save(@RequestBody final Log log) {
        Log saved = logService.save(log);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(saved, responseHeaders, HttpStatus.CREATED);
    }
}
