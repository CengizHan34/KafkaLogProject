package com.kafka.log.KafkaLogProject.entitys;

import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Created by Cengiz HAN
 */

@Data
@ToString
@Builder
public class Log {
    private Timestamp createLogDate;
    private LogLevelType logLevelType;
    private CityName cityName;
    private String logDetail;
}
