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

import org.apache.rocketmq.exporter.config.RMQConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class MQAdminInstance {

    private static final Logger log = LoggerFactory.getLogger(MQAdminInstance.class);

    private MQAdminExtImpl mqAdminExt;

    @Bean(name = "mqAdminExtImpl")
    public MQAdminExtImpl mqAdminExt(@Qualifier("rmqConfigure") RMQConfigure rmqConfigure) {
        log.info("Creating MQAdminExtImpl with namesrvAddr={}", rmqConfigure.getNamesrvAddr());
        mqAdminExt = new MQAdminExtImpl(rmqConfigure);
        return mqAdminExt;
    }

    @PreDestroy
    public void destroy() {
        if (mqAdminExt != null) {
            try {
                mqAdminExt.shutdown();
                log.info("MQAdminExtImpl shutdown successfully");
            } catch (Exception e) {
                log.error("Error shutting down MQAdminExtImpl", e);
            }
        }
    }
}
