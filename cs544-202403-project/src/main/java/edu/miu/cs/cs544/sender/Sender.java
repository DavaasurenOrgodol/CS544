package edu.miu.cs.cs544.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public void send(String topic, String message){
        kafkaTemplate.send(topic, message);
    }
}
