package com.kafka.log.KafkaLogProject.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Cengiz HAN
 */
@Data
@ToString
@Builder
public class ReportDto {
    private Date x;
    private long y;
}
