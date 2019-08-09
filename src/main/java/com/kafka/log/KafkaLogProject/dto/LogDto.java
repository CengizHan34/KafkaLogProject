package com.kafka.log.KafkaLogProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Cengiz HAN
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LogDto {
    private Long id;
    private String detail;
}
