package com.kafka.log.KafkaLogProject.dto;

import com.kafka.log.KafkaLogProject.type.CityName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Cengiz HAN
 */
@Data
@ToString
@Builder
public class ReportDto {
    private CityName cityName;
    private Long logCount;
}
