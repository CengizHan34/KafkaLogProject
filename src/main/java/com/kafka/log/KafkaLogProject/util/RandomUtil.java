package com.kafka.log.KafkaLogProject.util;

import java.util.Random;

/**
 * Created by Cengiz HAN
 */
public class RandomUtil {

    public static int getRandomNumberInRange(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }

}
