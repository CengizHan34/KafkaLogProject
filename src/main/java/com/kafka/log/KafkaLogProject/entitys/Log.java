package com.kafka.log.KafkaLogProject.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import lombok.*;

import javax.persistence.*;
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
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LogGenerator")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp createdDate;

    @Enumerated(EnumType.STRING)
    private LogLevelType levelType;

    @Enumerated(EnumType.STRING)
    private CityName cityName;

    private String detail;
}
