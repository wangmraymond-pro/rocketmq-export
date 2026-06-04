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
package org.apache.rocketmq.exporter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(prefix = "rocketmq.config")
public class RMQConfigure {

    private static final Logger log = LoggerFactory.getLogger(RMQConfigure.class);

    private String namesrvAddr;
    private String webTelemetryPath;
    private String rocketmqVersion;
    private boolean enableCollect;
    private boolean enableACL;
    private String accessKey;
    private String secretKey;
    private long outOfTimeSeconds;
    private long clientTimeout;

    @PostConstruct
    public void init() {
        log.info("RMQConfigure init, namesrvAddr={}, rocketmqVersion={}, enableCollect={}", 
            namesrvAddr, rocketmqVersion, enableCollect);
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getWebTelemetryPath() {
        return webTelemetryPath;
    }

    public void setWebTelemetryPath(String webTelemetryPath) {
        this.webTelemetryPath = webTelemetryPath;
    }

    public String getRocketmqVersion() {
        return rocketmqVersion;
    }

    public void setRocketmqVersion(String rocketmqVersion) {
        this.rocketmqVersion = rocketmqVersion;
    }

    public boolean isEnableCollect() {
        return enableCollect;
    }

    public void setEnableCollect(boolean enableCollect) {
        this.enableCollect = enableCollect;
    }

    public boolean isEnableACL() {
        return enableACL;
    }

    public void setEnableACL(boolean enableACL) {
        this.enableACL = enableACL;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getOutOfTimeSeconds() {
        return outOfTimeSeconds;
    }

    public void setOutOfTimeSeconds(long outOfTimeSeconds) {
        this.outOfTimeSeconds = outOfTimeSeconds;
    }

    public long getClientTimeout() {
        return clientTimeout;
    }

    public void setClientTimeout(long clientTimeout) {
        this.clientTimeout = clientTimeout;
    }
}
