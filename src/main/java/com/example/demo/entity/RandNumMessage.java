package com.example.demo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RandNumMessage {
    private final static Logger log =
            LoggerFactory.getLogger(RandNumMessage.class);

    static Random random = new Random();
    private Integer randNumber;

    public RandNumMessage() {
        // nextInt : 숫자 가지고 오기(이번 경우는 0~32)
        this.randNumber = random.nextInt(32) + 3;
        log.info("RandNumMessage(): " + randNumber);
    }

    public Integer getRandNumber() {

        return randNumber;
    }
}
