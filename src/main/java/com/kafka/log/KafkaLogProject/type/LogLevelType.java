package com.kafka.log.KafkaLogProject.type;

/**
 * Created by Cengiz HAN
 */
public enum LogLevelType {

    INFO, WARN, DEBUG, ERROR, FATAL, All;

    public String getLogLevel(Integer index) {
        return String.valueOf(LogLevelType.values()[index]);
    }
}
