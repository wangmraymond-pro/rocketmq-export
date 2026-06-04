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

import org.apache.rocketmq.exporter.config.RMQConfigure;
import org.apache.rocketmq.exporter.service.RMQMetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;

@RestController
public class RMQMetricsController {

    private static final Logger log = LoggerFactory.getLogger(RMQMetricsController.class);

    @Autowired
    private RMQMetricsService rmqMetricsService;

    @Autowired
    private RMQConfigure rmqConfigure;

    @RequestMapping(value = "/metrics", method = RequestMethod.GET)
    public void metrics(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain; version=0.0.4; charset=utf-8");
        try {
            StringWriter writer = new StringWriter();
            rmqMetricsService.metrics(writer);
            response.getWriter().write(writer.toString());
        } catch (IOException e) {
            log.error("Error getting metrics", e);
        }
    }
}
