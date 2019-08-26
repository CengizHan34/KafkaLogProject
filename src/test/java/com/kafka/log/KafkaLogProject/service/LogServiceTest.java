package com.kafka.log.KafkaLogProject.service;

import com.kafka.log.KafkaLogProject.entitys.Log;
import com.kafka.log.KafkaLogProject.repository.LogDao;
import com.kafka.log.KafkaLogProject.service.impl.LogServiceImpl;
import com.kafka.log.KafkaLogProject.type.CityName;
import com.kafka.log.KafkaLogProject.type.LogLevelType;
import mockit.Deencapsulation;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Cengiz HAN
 */
@RunWith(JMockit.class)
public class LogServiceTest {

    private LogService instance;
    private LogDao logDao;

    @Before
    public void setUp() {
        instance = new LogServiceImpl(logDao);
    }

    @Test
    public void save_ifLogObjectIsNotNull_ShouldBeReturnLogObject() {
        Log log = Log.builder().createdDate(new Timestamp(System.currentTimeMillis())).detail("test")
                .levelType(LogLevelType.INFO).cityName(CityName.Istanbul).build();

        MockUp<LogDao> logDaoMockUp = new MockUp<LogDao>() {
            @Mock(invocations = 1)
            <T> T save(T t) {
                Log log1 = (Log) t;
                log1.setId(1l);
                return (T) log1;
            }
        };

        Deencapsulation.setField(instance, "logDao", logDaoMockUp.getMockInstance());
        Log result = (Log) Deencapsulation.invoke(instance, "save", log);
        assertNotNull(result);
        assertEquals(java.util.Optional.ofNullable(result.getId()), java.util.Optional.of(1l));
    }

    @Test(expected = IllegalArgumentException.class)
    public void save_ifLogObjectIsNull_ShouldBeThrowException() {
        Log log = null;

        MockUp<LogDao> logDaoMockUp = new MockUp<LogDao>() {
            @Mock(invocations = 0)
            <T> T save(T t) {
                Log log1 = (Log) t;
                log1.setId(1l);
                return (T) log1;
            }
        };

        Deencapsulation.setField(instance, "logDao", logDaoMockUp.getMockInstance());
        Log result = (Log) Deencapsulation.invoke(instance, "save", log);
    }

}
