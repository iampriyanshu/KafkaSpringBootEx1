package com.priyanshuthakuria.controller;

import com.priyanshuthakuria.model.User;
import com.priyanshuthakuria.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    KafkaProducer producer;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        this.producer.sendMessage(user);
    }
}
