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