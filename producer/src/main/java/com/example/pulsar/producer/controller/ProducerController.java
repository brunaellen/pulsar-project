package com.example.pulsar.producer.controller;

import com.example.pulsar.producer.service.ProducerService;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private ProducerService producer;

    public ProducerController(ProducerService producer) {
        this.producer = producer;
    }

    @GetMapping("/produce/{message}")
    public ResponseEntity<MessageId> produce(@PathVariable String message) throws PulsarClientException {
        MessageId produce = producer.produce(message);
        return ResponseEntity.ok(produce);
    }
}
