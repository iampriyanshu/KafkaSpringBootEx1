package com.priyanshuthakuria.controller;

import com.priyanshuthakuria.model.User;
import com.priyanshuthakuria.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
