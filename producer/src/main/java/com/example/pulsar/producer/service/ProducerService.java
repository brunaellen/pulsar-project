package com.example.pulsar.producer.service;

import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProducerService {

    private PulsarClient pulsarClient;
    private Producer<String> stringProducer;

    @PostConstruct
    private void init() throws PulsarClientException {
        pulsarClient = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        stringProducer = pulsarClient.newProducer(Schema.STRING)
                .topic("my-topic")
                .create();
    }

    public MessageId produce(final String message) throws PulsarClientException {
        return stringProducer.send(message);
    }
}
