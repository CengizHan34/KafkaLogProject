package com.kafka.log.KafkaLogProject.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Cengiz HAN
 */

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(name = "LogGenerator", sequenceName = "LogSequence", allocationSize = 1)
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LogGenerator")
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp createLogDate;
    @Enumerated(EnumType.STRING)
    private LogLevelType logLevelType;
    @Enumerated(EnumType.STRING)
    private CityName cityName;
    private String logDetail;
}
