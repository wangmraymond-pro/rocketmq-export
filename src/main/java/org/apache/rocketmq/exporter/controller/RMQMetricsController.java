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
package org.apache.rocketmq.exporter.controller;

import io.prometheus.client.exporter.common.TextFormat;
import org.apache.rocketmq.exporter.service.RMQMetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@RestController
@RequestMapping("/")
public class RMQMetricsController {

    private static final Logger log = LoggerFactory.getLogger(RMQMetricsController.class);

    @Resource
    @Qualifier("rmqMetricsService")
    RMQMetricsService rmqMetricsService;

    @GetMapping("/metrics")
    public void getMetrics(HttpServletResponse response) throws IOException {
        response.setContentType(TextFormat.CONTENT_TYPE_004);
        Writer writer = response.getWriter();
        try {
            rmqMetricsService.getCollector().collect().write(writer);
        } catch (Exception e) {
            log.error("getMetrics error", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.write("# Error getting metrics: " + e.getMessage());
        } finally {
            writer.flush();
            writer.close();
        }
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
