package com.kafka.log.KafkaLogProject.type;

/**
 * Created by Cengiz HAN
 */
public enum CityName {

    Istanbul, Tokyo, Moskow, Beijing, London, All;

    public String getCity(int index) {
        return String.valueOf(CityName.values()[index]);
    }
}
