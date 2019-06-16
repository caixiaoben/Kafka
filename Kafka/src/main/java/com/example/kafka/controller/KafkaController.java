package com.example.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	private static Logger logger = LoggerFactory.getLogger(KafkaController.class);
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/kafka")
	public String testKafka() {
		kafkaTemplate.send("study", "data" +"success" );
		return "success";
	}


}