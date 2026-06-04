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
package org.apache.rocketmq.exporter.service.client;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.common.message.MessageDecoder;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.exporter.config.RMQConfigure;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MQAdminExtImpl extends DefaultMQAdminExt {

    private static final Logger log = LoggerFactory.getLogger(MQAdminExtImpl.class);

    public MQAdminExtImpl(RMQConfigure rmqConfigure) {
        super(createAdminConfig(rmqConfigure));
        try {
            start();
            log.info("MQAdminExtImpl started successfully, namesrvAddr={}", rmqConfigure.getNamesrvAddr());
        } catch (MQClientException e) {
            log.error("Failed to start MQAdminExtImpl", e);
            throw new RuntimeException(e);
        }
    }

    private static DefaultMQAdminExt.DefaultMQAdminExtConfig createAdminConfig(RMQConfigure rmqConfigure) {
        DefaultMQAdminExt.DefaultMQAdminExtConfig config = new DefaultMQAdminExt.DefaultMQAdminExtConfig();
        config.setNamesrvAddr(rmqConfigure.getNamesrvAddr());
        config.setAdminExtGroup(MixAll.DEFAULT_ADMIN_EXTERNAL_CONFIG_GROUP);
        config.setTimeout((int) rmqConfigure.getClientTimeout());
        if (rmqConfigure.isEnableACL()) {
            config.setAccessKey(rmqConfigure.getAccessKey());
            config.setSecretKey(rmqConfigure.getSecretKey());
        }
        return config;
    }

    public MessageExt queryMsgByOffset(MessageQueue mq, long offset) {
        try {
            List<MessageExt> messages = viewMessage(mq.getTopic(), offset, 1);
            if (messages != null && !messages.isEmpty()) {
                return messages.get(0);
            }
        } catch (Exception e) {
            log.debug("queryMsgByOffset failed for queue {}, offset {}, error: {}", mq, offset, e.getMessage());
        }
        return null;
    }

    public void shutdown() {
        try {
            super.shutdown();
        } catch (Exception e) {
            log.warn("Error during shutdown", e);
        }
    }
}
