# Application was made using:

* Spring Boot 2.6.7
* Java 11
* pulsar 2.10.0
* Docker

# Pulsar Overview
Pulsar is a multi-tenant, high-performance solution for server-to-server messaging.

Pulsar is built on the publish-subscribe pattern.<br/>
In this pattern, producers publish messages to topics; consumers subscribe to those topics, process incoming messages, and send acknowledgements to the broker when processing is finished.

When a subscription is created, Pulsar retains all messages, even if the consumer is disconnected. The retained messages are discarded only when a consumer acknowledges that all these messages are processed successfully.
Pulsar is:<br/>
* A simple client API with bindings for Java, Go, Python and C++.
* Guaranteed message delivery with persistent message storage provided by Apache BookKeeper.
* A serverless light-weight computing framework Pulsar Functions offers the capability for stream-native data processing.


# Starting pulsar

```bash
docker-compose up -d
```

# Pulsar Java Client

https://pulsar.apache.org/docs/en/client-libraries-java/

# Create a topic

```bash
# will create a topic with name "my-topic"
curl -X PUT http://localhost:8080/admin/v2/persistent/public/default/my-topic/

# reference: https://pulsar.apache.org/docs/en/admin-api-topics/
```

# Get topic statistics

```bash
curl http://localhost:8080/admin/v2/persistent/public/default/my-topic/stats
```