package com.priyanshuthakuria.service;

import com.priyanshuthakuria.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Value(value = "${kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User message) {
        logger.info(String.format("#### -> Producing message -> %s", message.toString()));
        this.kafkaTemplate.send(topic, message);
    }
}
