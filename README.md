# Apache RocketMQ Exporter

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

RocketMQ Exporter is a Prometheus exporter for Apache RocketMQ, which collects metrics from RocketMQ clusters and exposes them in a format compatible with Prometheus.

## Features

- Collects metrics from RocketMQ NameServer and Brokers
- Supports Prometheus format metrics
- Supports OpenTelemetry metrics
- Collects consumer group lag, broker stats, topic stats, producer/consumer counts
- Client-level metrics for consumer runtime stats

## Quick Start

### Prerequisites

- Java 8+
- Maven 3.6+
- RocketMQ 4.9.4+

### Build

```bash
mvn clean install -DskipTests
```

### Run

```bash
java -jar target/rocketmq-exporter-0.0.3-SNAPSHOT-exec.jar --rocketmq.config.namesrvAddr=localhost:9876
```

### Configuration

Configuration can be set via `application.yml` or command line arguments:

| Parameter | Description | Default |
|-----------|-------------|--------|
| rocketmq.config.namesrvAddr | NameServer address | localhost:9876 |
| rocketmq.config.enableCollect | Enable metrics collection | true |
| rocketmq.config.enableACL | Enable ACL | false |
| rocketmq.config.accessKey | ACL access key | 
| rocketmq.config.secretKey | ACL secret key | 
| server.port | HTTP server port | 9000 |
| grpc.server.port | gRPC server port | 5559 |

### Metrics Endpoint

```
http://localhost:9000/metrics
```

### Health Check

```
http://localhost:9000/health
```

## Collected Metrics

### Consumer Metrics

| Metric | Description | Labels |
|--------|-------------|--------|
| rocketmq_group_lag_total | Consumer group lag | group, topic, countOfOnlineConsumers, msgModel |
| rocketmq_group_count | Online consumer count | caddr, localaddr, group |
| rocketmq_group_retrydiff | Retry topic lag | group, topic, countOfOnlineConsumers, msgModel |
| rocketmq_group_dlqdiff | DLQ topic lag | group, topic, countOfOnlineConsumers, msgModel |

### Producer Metrics

| Metric | Description | Labels |
|--------|-------------|--------|
| rocketmq_producer_count | Producer instance count | cluster, broker, group |
| rocketmq_producer_offset | Topic offset | cluster, broker, topic |

### Broker Metrics

| Metric | Description | Labels |
|--------|-------------|--------|
| rocketmq_broker_tps | Broker put TPS | cluster, brokerIP, broker |
| rocketmq_broker_qps | Broker get TPS | cluster, brokerIP, broker |
| rocketmq_cluster_broker_count | Cluster broker count | cluster |
| rocketmq_cluster_topic_count | Cluster topic count | cluster |

### Client Runtime Metrics

| Metric | Description | Labels |
|--------|-------------|--------|
| rocketmq_client_consume_ok_msg_tps | Consumer consume OK TPS | clientAddr, clientId, group, topic |
| rocketmq_client_consume_fail_msg_tps | Consumer consume fail TPS | clientAddr, clientId, group, topic |
| rocketmq_client_consume_rt | Consumer consume RT | clientAddr, clientId, group, topic |
| rocketmq_client_consumer_pull_rt | Consumer pull RT | clientAddr, clientId, group, topic |
| rocketmq_client_consumer_pull_tps | Consumer pull TPS | clientAddr, clientId, group, topic |

## Alert Rules

See `alert_rules.yml` for example alert rules.

## License

Apache License, Version 2.0
