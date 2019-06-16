package com.example.kafka.producer;

import java.util.Date;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.kafka.message.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class KafkaProducer {
    
    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("study", gson.toJson(message));
    }
}
