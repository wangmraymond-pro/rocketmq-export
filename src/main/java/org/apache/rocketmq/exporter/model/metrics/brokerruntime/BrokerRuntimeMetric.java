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
package org.apache.rocketmq.exporter.model.metrics.brokerruntime;

import java.util.Objects;

public class BrokerRuntimeMetric {

    private String clusterName;
    private String brokerAddr;
    private String brokerHost;
    private String brokerVersionDesc;
    private long bootTimestamp;
    private double brokerVersion;

    public BrokerRuntimeMetric(String clusterName, String brokerAddr, String brokerHost,
        String brokerVersionDesc, long bootTimestamp, double brokerVersion) {
        this.clusterName = clusterName;
        this.brokerAddr = brokerAddr;
        this.brokerHost = brokerHost;
        this.brokerVersionDesc = brokerVersionDesc;
        this.bootTimestamp = bootTimestamp;
        this.brokerVersion = brokerVersion;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getBrokerAddr() {
        return brokerAddr;
    }

    public void setBrokerAddr(String brokerAddr) {
        this.brokerAddr = brokerAddr;
    }

    public String getBrokerHost() {
        return brokerHost;
    }

    public void setBrokerHost(String brokerHost) {
        this.brokerHost = brokerHost;
    }

    public String getBrokerVersionDesc() {
        return brokerVersionDesc;
    }

    public void setBrokerVersionDesc(String brokerVersionDesc) {
        this.brokerVersionDesc = brokerVersionDesc;
    }

    public long getBootTimestamp() {
        return bootTimestamp;
    }

    public void setBootTimestamp(long bootTimestamp) {
        this.bootTimestamp = bootTimestamp;
    }

    public double getBrokerVersion() {
        return brokerVersion;
    }

    public void setBrokerVersion(double brokerVersion) {
        this.brokerVersion = brokerVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokerRuntimeMetric)) return false;
        BrokerRuntimeMetric that = (BrokerRuntimeMetric) o;
        return bootTimestamp == that.bootTimestamp &&
            Double.compare(that.brokerVersion, brokerVersion) == 0 &&
            Objects.equals(clusterName, that.clusterName) &&
            Objects.equals(brokerAddr, that.brokerAddr) &&
            Objects.equals(brokerHost, that.brokerHost) &&
            Objects.equals(brokerVersionDesc, that.brokerVersionDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterName, brokerAddr, brokerHost, brokerVersionDesc, bootTimestamp, brokerVersion);
    }
}
