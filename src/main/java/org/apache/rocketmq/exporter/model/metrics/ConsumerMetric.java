/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.rocketmq.exporter.model.metrics;

import java.util.Objects;

public class ConsumerMetric {

    private String clusterName;
    private String brokerName;
    private String topicName;
    private String consumerGroupName;

    public ConsumerMetric(String clusterName, String brokerName, String topicName, String consumerGroupName) {
        this.clusterName = clusterName;
        this.brokerName = brokerName;
        this.topicName = topicName;
        this.consumerGroupName = consumerGroupName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getConsumerGroupName() {
        return consumerGroupName;
    }

    public void setConsumerGroupName(String consumerGroupName) {
        this.consumerGroupName = consumerGroupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumerMetric)) return false;
        ConsumerMetric that = (ConsumerMetric) o;
        return Objects.equals(clusterName, that.clusterName) &&
            Objects.equals(brokerName, that.brokerName) &&
            Objects.equals(topicName, that.topicName) &&
            Objects.equals(consumerGroupName, that.consumerGroupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterName, brokerName, topicName, consumerGroupName);
    }
}
