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
package org.apache.rocketmq.exporter.service.impl;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.common.TextFormat;
import org.apache.rocketmq.exporter.collector.RMQMetricsCollector;
import org.apache.rocketmq.exporter.config.RMQConfigure;
import org.apache.rocketmq.exporter.service.RMQMetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringWriter;

@Service
public class RMQMetricsServiceImpl implements RMQMetricsService {

    private static final Logger log = LoggerFactory.getLogger(RMQMetricsServiceImpl.class);

    private RMQMetricsCollector collector;
    private final RMQConfigure rmqConfigure;

    public RMQMetricsServiceImpl(RMQConfigure rmqConfigure) {
        this.rmqConfigure = rmqConfigure;
    }

    @PostConstruct
    public void init() {
        log.info("RMQMetricsServiceImpl init");
        collector = new RMQMetricsCollector(rmqConfigure.getOutOfTimeSeconds());
        CollectorRegistry.defaultRegistry.register(collector);
    }

    @Override
    public RMQMetricsCollector getCollector() {
        return collector;
    }

    @Override
    public void metrics(StringWriter writer) throws IOException {
        TextFormat.write004(writer, CollectorRegistry.defaultRegistry.metricFamilySamples());
    }
}
