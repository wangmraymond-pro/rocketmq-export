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
package org.apache.rocketmq.exporter.model.metrics.clientrunime;

import java.util.Objects;

public class ConsumerRuntimePullRTMetric {
    private String group;
    private String topic;
    private String caddrs;
    private String localaddrs;

    public ConsumerRuntimePullRTMetric(String group, String topic, String caddrs, String localaddrs) {
        this.group = group;
        this.topic = topic;
        this.caddrs = caddrs;
        this.localaddrs = localaddrs;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCaddrs() {
        return caddrs;
    }

    public void setCaddrs(String caddrs) {
        this.caddrs = caddrs;
    }

    public String getLocaladdrs() {
        return localaddrs;
    }

    public void setLocaladdrs(String localaddrs) {
        this.localaddrs = localaddrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerRuntimePullRTMetric that = (ConsumerRuntimePullRTMetric) o;
        return Objects.equals(group, that.group) &&
            Objects.equals(topic, that.topic) &&
            Objects.equals(caddrs, that.caddrs) &&
            Objects.equals(localaddrs, that.localaddrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, topic, caddrs, localaddrs);
    }
}
