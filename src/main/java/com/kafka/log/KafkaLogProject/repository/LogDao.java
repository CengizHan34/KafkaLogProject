package com.kafka.log.KafkaLogProject.repository;

import com.kafka.log.KafkaLogProject.entitys.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cengiz HAN
 */

@Repository
@Transactional
public interface LogDao extends JpaRepository<Log, Long> {
}
