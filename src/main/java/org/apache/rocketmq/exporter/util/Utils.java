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
package org.apache.rocketmq.exporter.util;

import java.math.BigDecimal;

public class Utils {

    public static Double getFixedDouble(Double value) {
        if (value == null) {
            return 0.0;
        }
        BigDecimal bg = new BigDecimal(value.toString());
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String getHostAddress(String address) {
        if (address == null || address.isEmpty()) {
            return "";
        }
        int index = address.indexOf(":");
        if (index > 0) {
            return address.substring(0, index);
        }
        return address;
    }
}
