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
package org.apache.rocketmq.exporter.task;

import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.common.protocol.body.Connection;
import org.apache.rocketmq.common.protocol.body.ConsumerConnection;
import org.apache.rocketmq.exporter.service.RMQMetricsService;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import org.slf4j.Logger;

import java.util.Map;

public class ClientMetricTaskRunnable implements Runnable {

    private String group;
    private ConsumerConnection consumerConnection;
    private boolean isProducer;
    private MQAdminExt mqAdminExt;
    private Logger log;
    private RMQMetricsService metricsService;

    public ClientMetricTaskRunnable(String group, ConsumerConnection consumerConnection,
        boolean isProducer, MQAdminExt mqAdminExt, Logger log, RMQMetricsService metricsService) {
        this.group = group;
        this.consumerConnection = consumerConnection;
        this.isProducer = isProducer;
        this.mqAdminExt = mqAdminExt;
        this.log = log;
        this.metricsService = metricsService;
    }

    @Override
    public void run() {
        if (consumerConnection == null || consumerConnection.getConnectionSet() == null) {
            return;
        }

        for (Connection connection : consumerConnection.getConnectionSet()) {
            try {
                String clientId = connection.getClientId();
                String clientAddr = connection.getClientAddr();
                String language = connection.getLanguage();
                String version = connection.getVersion();
                Map<String, String> props = connection.getProperties();

                if (!isProducer) {
                    String consumeFromWhere = props.get(MixAll.CONSUME_FROM_WHERE);
                    String messageModel = props.get(MixAll.MESSAGE_MODEL);
                    String consumeType = props.get(MixAll.CONSUME_TYPE);
                    String consumeMessageBatchMaxSize = props.get(MixAll.CONSUME_MESSAGE_BATCH_MAX_SIZE);

                    Long consumeOKTPS = null;
                    Long consumeFailedTPS = null;
                    Long consumeRT = null;
                    Long pullRT = null;
                    Long pullTPS = null;
                    Long consumeFailedMsgCount = null;

                    if (props.get("consumeOKTPS") != null) {
                        consumeOKTPS = Long.parseLong(props.get("consumeOKTPS"));
                    }
                    if (props.get("consumeFailedTPS") != null) {
                        consumeFailedTPS = Long.parseLong(props.get("consumeFailedTPS"));
                    }
                    if (props.get("consumeRT") != null) {
                        consumeRT = Long.parseLong(props.get("consumeRT"));
                    }
                    if (props.get("pullRT") != null) {
                        pullRT = Long.parseLong(props.get("pullRT"));
                    }
                    if (props.get("pullTPS") != null) {
                        pullTPS = Long.parseLong(props.get("pullTPS"));
                    }
                    if (props.get("consumeFailedMsgCount") != null) {
                        consumeFailedMsgCount = Long.parseLong(props.get("consumeFailedMsgCount"));
                    }

                    for (String topic : consumerConnection.getSubscriptionSet().keySet()) {
                        if (consumeOKTPS != null) {
                            metricsService.getCollector().addConsumerClientOKTPSMetric(group, topic, clientAddr, clientId, consumeOKTPS);
                        }
                        if (consumeFailedTPS != null) {
                            metricsService.getCollector().addConsumerClientFailedTPSMetric(group, topic, clientAddr, clientId, consumeFailedTPS);
                        }
                        if (consumeRT != null) {
                            metricsService.getCollector().addConsumeRTMetricMetric(group, topic, clientAddr, clientId, consumeRT);
                        }
                        if (pullRT != null) {
                            metricsService.getCollector().addPullRTMetric(group, topic, clientAddr, clientId, pullRT);
                        }
                        if (pullTPS != null) {
                            metricsService.getCollector().addPullTPSMetric(group, topic, clientAddr, clientId, pullTPS);
                        }
                        if (consumeFailedMsgCount != null) {
                            metricsService.getCollector().addConsumerClientFailedMsgCountsMetric(group, topic, clientAddr, clientId, consumeFailedMsgCount);
                        }
                    }
                }
            } catch (Exception e) {
                log.warn("collect client metric error, group={}, clientId={}, error={}", group, 
                    connection.getClientId(), e.getMessage());
            }
        }
    }
}
