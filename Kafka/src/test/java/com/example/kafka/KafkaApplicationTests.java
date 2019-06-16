package com.example.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.kafka.producer.KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {
	@Autowired
	private KafkaProducer kafkaProducer;
	@Test
	public void contextLoads() {
		kafkaProducer.send();
	}

}
