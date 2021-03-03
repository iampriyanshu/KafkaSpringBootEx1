package com.priyanshuthakuria.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Value(value = "${kafka.consumer.topic}")
    private String topic;

    @KafkaListener(topics = "priyanshu", groupId = "group-id")
    public void consume(Object message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message.toString()));
    }
}
