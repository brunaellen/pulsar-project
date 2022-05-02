package com.example.pulsar.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class MyConsumer {
    private PulsarClient pulsarClient;
    private Consumer<String> stringConsumer;

    @PostConstruct
    private void init() throws PulsarClientException {
        pulsarClient = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        stringConsumer = pulsarClient.newConsumer(Schema.STRING)
                .topic("my-topic")
                .subscriptionName("my-subscription")
                .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                .messageListener((consumer, msg) -> {
                    try {
                        log.info("message received: " + new String(msg.getData()));
                        consumer.acknowledge(msg);
                    } catch (PulsarClientException e) {
                        consumer.negativeAcknowledge(msg);
                        e.printStackTrace();
                    }

                })
                .subscribe();
    }
}
