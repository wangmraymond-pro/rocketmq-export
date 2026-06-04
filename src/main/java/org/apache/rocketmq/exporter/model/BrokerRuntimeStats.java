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
package org.apache.rocketmq.exporter.model;

import org.apache.rocketmq.common.protocol.body.KVTable;

public class BrokerRuntimeStats {

    private long msgPutTotalTodayNow;
    private long msgGetTotalTodayNow;
    private long msgPutTotalTodayMorning;
    private long msgGetTotalTodayMorning;
    private long msgPutTotalYesterdayMorning;
    private long msgGetTotalYesterdayMorning;
    private long putMessageSizeTotal;
    private double putMessageAverageSize;
    private long commitLogMaxOffset;
    private long commitLogMinOffset;
    private long dispatchBehindBytes;
    private long queryThreadPoolQueueCapacity;
    private long remainTransientStoreBufferNumbs;
    private long earliestMessageTimeStamp;
    private long putMessageEntireTimeMax;
    private long startAcceptSendRequestTimeStamp;
    private long sendThreadPoolQueueSize;
    private long putMessageTimesTotal;
    private long getMessageEntireTimeMax;
    private long pageCacheLockTimeMills;
    private double commitLogDiskRatio;
    private double consumeQueueDiskRatio;
    private double putLatency99;
    private double putLatency999;
    private double getLatency99;
    private double getLatency999;
    private double storagePressure;
    private int putMessageDistributeTimeMap0ms;
    private int putMessageDistributeTimeMap0to10ms;
    private int putMessageDistributeTimeMap10to50ms;
    private int putMessageDistributeTimeMap50to100ms;
    private int putMessageDistributeTimeMap100to200ms;
    private int putMessageDistributeTimeMap200to500ms;
    private int putMessageDistributeTimeMap500to1s;
    private int putMessageDistributeTimeMap1to2s;
    private int putMessageDistributeTimeMap2to3s;
    private int putMessageDistributeTimeMap3to4s;
    private int putMessageDistributeTimeMap4to5s;
    private int putMessageDistributeTimeMap5to10s;
    private int putMessageDistributeTimeMap10toMore;
    private long pullThreadPoolQueueCapacity;
    private long sendThreadPoolQueueCapacity;
    private long pullThreadPoolQueueSize;
    private long queryThreadPoolQueueSize;
    private long pullThreadPoolQueueHeadWaitTimeMills;
    private long queryThreadPoolQueueHeadWaitTimeMills;
    private long sendThreadPoolQueueHeadWaitTimeMills;
    private double commitLogDirCapacityFree;
    private double commitLogDirCapacityTotal;
    private double remainHowManyDataToFlush;
    private double getFoundTps600;
    private double getFoundTps60;
    private double getFoundTps10;
    private double getTotalTps600;
    private double getTotalTps60;
    private double getTotalTps10;
    private double getTransferedTps600;
    private double getTransferedTps60;
    private double getTransferedTps10;
    private double getMissTps600;
    private double getMissTps60;
    private double getMissTps10;
    private double putTps600;
    private double putTps60;
    private double putTps10;
    private String brokerVersionDesc;
    private long bootTimestamp;
    private double brokerVersion;

    public BrokerRuntimeStats(KVTable kvTable) {
        parseKVTable(kvTable);
    }

    private void parseKVTable(KVTable kvTable) {
        if (kvTable == null || kvTable.getTable() == null) {
            return;
        }
        this.msgPutTotalTodayNow = getLongValue(kvTable, "msgPutTotalTodayNow", 0);
        this.msgGetTotalTodayNow = getLongValue(kvTable, "msgGetTotalTodayNow", 0);
        this.msgPutTotalTodayMorning = getLongValue(kvTable, "msgPutTotalTodayMorning", 0);
        this.msgGetTotalTodayMorning = getLongValue(kvTable, "msgGetTotalTodayMorning", 0);
        this.msgPutTotalYesterdayMorning = getLongValue(kvTable, "msgPutTotalYesterdayMorning", 0);
        this.msgGetTotalYesterdayMorning = getLongValue(kvTable, "msgGetTotalYesterdayMorning", 0);
        this.putMessageSizeTotal = getLongValue(kvTable, "putMessageSizeTotal", 0);
        this.putMessageAverageSize = getDoubleValue(kvTable, "putMessageAverageSize", 0);
        this.commitLogMaxOffset = getLongValue(kvTable, "commitLogMaxOffset", 0);
        this.commitLogMinOffset = getLongValue(kvTable, "commitLogMinOffset", 0);
        this.dispatchBehindBytes = getLongValue(kvTable, "dispatchBehindBytes", 0);
        this.queryThreadPoolQueueCapacity = getLongValue(kvTable, "queryThreadPoolQueueCapacity", 0);
        this.remainTransientStoreBufferNumbs = getLongValue(kvTable, "remainTransientStoreBufferNumbs", 0);
        this.earliestMessageTimeStamp = getLongValue(kvTable, "earliestMessageTimeStamp", 0);
        this.putMessageEntireTimeMax = getLongValue(kvTable, "putMessageEntireTimeMax", 0);
        this.startAcceptSendRequestTimeStamp = getLongValue(kvTable, "startAcceptSendRequestTimeStamp", 0);
        this.sendThreadPoolQueueSize = getLongValue(kvTable, "sendThreadPoolQueueSize", 0);
        this.putMessageTimesTotal = getLongValue(kvTable, "putMessageTimesTotal", 0);
        this.getMessageEntireTimeMax = getLongValue(kvTable, "getMessageEntireTimeMax", 0);
        this.pageCacheLockTimeMills = getLongValue(kvTable, "pageCacheLockTimeMills", 0);
        this.commitLogDiskRatio = getDoubleValue(kvTable, "commitLogDiskRatio", 0);
        this.consumeQueueDiskRatio = getDoubleValue(kvTable, "consumeQueueDiskRatio", 0);
        this.putLatency99 = getDoubleValue(kvTable, "putLatency99", 0);
        this.putLatency999 = getDoubleValue(kvTable, "putLatency999", 0);
        this.getLatency99 = getDoubleValue(kvTable, "getLatency99", 0);
        this.getLatency999 = getDoubleValue(kvTable, "getLatency999", 0);
        this.storagePressure = getDoubleValue(kvTable, "storagePressure", 0);
        this.putMessageDistributeTimeMap0ms = getIntValue(kvTable, "putMessageDistributeTimeMap0ms", 0);
        this.putMessageDistributeTimeMap0to10ms = getIntValue(kvTable, "putMessageDistributeTimeMap0to10ms", 0);
        this.putMessageDistributeTimeMap10to50ms = getIntValue(kvTable, "putMessageDistributeTimeMap10to50ms", 0);
        this.putMessageDistributeTimeMap50to100ms = getIntValue(kvTable, "putMessageDistributeTimeMap50to100ms", 0);
        this.putMessageDistributeTimeMap100to200ms = getIntValue(kvTable, "putMessageDistributeTimeMap100to200ms", 0);
        this.putMessageDistributeTimeMap200to500ms = getIntValue(kvTable, "putMessageDistributeTimeMap200to500ms", 0);
        this.putMessageDistributeTimeMap500to1s = getIntValue(kvTable, "putMessageDistributeTimeMap500to1s", 0);
        this.putMessageDistributeTimeMap1to2s = getIntValue(kvTable, "putMessageDistributeTimeMap1to2s", 0);
        this.putMessageDistributeTimeMap2to3s = getIntValue(kvTable, "putMessageDistributeTimeMap2to3s", 0);
        this.putMessageDistributeTimeMap3to4s = getIntValue(kvTable, "putMessageDistributeTimeMap3to4s", 0);
        this.putMessageDistributeTimeMap4to5s = getIntValue(kvTable, "putMessageDistributeTimeMap4to5s", 0);
        this.putMessageDistributeTimeMap5to10s = getIntValue(kvTable, "putMessageDistributeTimeMap5to10s", 0);
        this.putMessageDistributeTimeMap10toMore = getIntValue(kvTable, "putMessageDistributeTimeMap10toMore", 0);
        this.pullThreadPoolQueueCapacity = getLongValue(kvTable, "pullThreadPoolQueueCapacity", 0);
        this.sendThreadPoolQueueCapacity = getLongValue(kvTable, "sendThreadPoolQueueCapacity", 0);
        this.pullThreadPoolQueueSize = getLongValue(kvTable, "pullThreadPoolQueueSize", 0);
        this.queryThreadPoolQueueSize = getLongValue(kvTable, "queryThreadPoolQueueSize", 0);
        this.pullThreadPoolQueueHeadWaitTimeMills = getLongValue(kvTable, "pullThreadPoolQueueHeadWaitTimeMills", 0);
        this.queryThreadPoolQueueHeadWaitTimeMills = getLongValue(kvTable, "queryThreadPoolQueueHeadWaitTimeMills", 0);
        this.sendThreadPoolQueueHeadWaitTimeMills = getLongValue(kvTable, "sendThreadPoolQueueHeadWaitTimeMills", 0);
        this.commitLogDirCapacityFree = getDoubleValue(kvTable, "commitLogDirCapacityFree", 0);
        this.commitLogDirCapacityTotal = getDoubleValue(kvTable, "commitLogDirCapacityTotal", 0);
        this.remainHowManyDataToFlush = getDoubleValue(kvTable, "remainHowManyDataToFlush", 0);
        this.getFoundTps600 = getDoubleValue(kvTable, "getFoundTps600", 0);
        this.getFoundTps60 = getDoubleValue(kvTable, "getFoundTps60", 0);
        this.getFoundTps10 = getDoubleValue(kvTable, "getFoundTps10", 0);
        this.getTotalTps600 = getDoubleValue(kvTable, "getTotalTps600", 0);
        this.getTotalTps60 = getDoubleValue(kvTable, "getTotalTps60", 0);
        this.getTotalTps10 = getDoubleValue(kvTable, "getTotalTps10", 0);
        this.getTransferedTps600 = getDoubleValue(kvTable, "getTransferedTps600", 0);
        this.getTransferedTps60 = getDoubleValue(kvTable, "getTransferedTps60", 0);
        this.getTransferedTps10 = getDoubleValue(kvTable, "getTransferedTps10", 0);
        this.getMissTps600 = getDoubleValue(kvTable, "getMissTps600", 0);
        this.getMissTps60 = getDoubleValue(kvTable, "getMissTps60", 0);
        this.getMissTps10 = getDoubleValue(kvTable, "getMissTps10", 0);
        this.putTps600 = getDoubleValue(kvTable, "putTps600", 0);
        this.putTps60 = getDoubleValue(kvTable, "putTps60", 0);
        this.putTps10 = getDoubleValue(kvTable, "putTps10", 0);
        this.brokerVersionDesc = kvTable.getTable().get("brokerVersionDesc");
        this.bootTimestamp = getLongValue(kvTable, "bootTimestamp", 0);
        this.brokerVersion = getDoubleValue(kvTable, "brokerVersion", 0);
    }

    private long getLongValue(KVTable kvTable, String key, long defaultValue) {
        String value = kvTable.getTable().get(key);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private double getDoubleValue(KVTable kvTable, String key, double defaultValue) {
        String value = kvTable.getTable().get(key);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private int getIntValue(KVTable kvTable, String key, int defaultValue) {
        String value = kvTable.getTable().get(key);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public long getMsgPutTotalTodayNow() { return msgPutTotalTodayNow; }
    public long getMsgGetTotalTodayNow() { return msgGetTotalTodayNow; }
    public long getMsgPutTotalTodayMorning() { return msgPutTotalTodayMorning; }
    public long getMsgGetTotalTodayMorning() { return msgGetTotalTodayMorning; }
    public long getMsgPutTotalYesterdayMorning() { return msgPutTotalYesterdayMorning; }
    public long getMsgGetTotalYesterdayMorning() { return msgGetTotalYesterdayMorning; }
    public long getPutMessageSizeTotal() { return putMessageSizeTotal; }
    public double getPutMessageAverageSize() { return putMessageAverageSize; }
    public long getCommitLogMaxOffset() { return commitLogMaxOffset; }
    public long getCommitLogMinOffset() { return commitLogMinOffset; }
    public long getDispatchBehindBytes() { return dispatchBehindBytes; }
    public long getQueryThreadPoolQueueCapacity() { return queryThreadPoolQueueCapacity; }
    public long getRemainTransientStoreBufferNumbs() { return remainTransientStoreBufferNumbs; }
    public long getEarliestMessageTimeStamp() { return earliestMessageTimeStamp; }
    public long getPutMessageEntireTimeMax() { return putMessageEntireTimeMax; }
    public long getStartAcceptSendRequestTimeStamp() { return startAcceptSendRequestTimeStamp; }
    public long getSendThreadPoolQueueSize() { return sendThreadPoolQueueSize; }
    public long getPutMessageTimesTotal() { return putMessageTimesTotal; }
    public long getGetMessageEntireTimeMax() { return getMessageEntireTimeMax; }
    public long getPageCacheLockTimeMills() { return pageCacheLockTimeMills; }
    public double getCommitLogDiskRatio() { return commitLogDiskRatio; }
    public double getConsumeQueueDiskRatio() { return consumeQueueDiskRatio; }
    public double getPutLatency99() { return putLatency99; }
    public double getPutLatency999() { return putLatency999; }
    public double getGetLatency99() { return getLatency99; }
    public double getGetLatency999() { return getLatency999; }
    public double getStoragePressure() { return storagePressure; }
    public int getPutMessageDistributeTimeMap0ms() { return putMessageDistributeTimeMap0ms; }
    public int getPutMessageDistributeTimeMap0to10ms() { return putMessageDistributeTimeMap0to10ms; }
    public int getPutMessageDistributeTimeMap10to50ms() { return putMessageDistributeTimeMap10to50ms; }
    public int getPutMessageDistributeTimeMap50to100ms() { return putMessageDistributeTimeMap50to100ms; }
    public int getPutMessageDistributeTimeMap100to200ms() { return putMessageDistributeTimeMap100to200ms; }
    public int getPutMessageDistributeTimeMap200to500ms() { return putMessageDistributeTimeMap200to500ms; }
    public int getPutMessageDistributeTimeMap500to1s() { return putMessageDistributeTimeMap500to1s; }
    public int getPutMessageDistributeTimeMap1to2s() { return putMessageDistributeTimeMap1to2s; }
    public int getPutMessageDistributeTimeMap2to3s() { return putMessageDistributeTimeMap2to3s; }
    public int getPutMessageDistributeTimeMap3to4s() { return putMessageDistributeTimeMap3to4s; }
    public int getPutMessageDistributeTimeMap4to5s() { return putMessageDistributeTimeMap4to5s; }
    public int getPutMessageDistributeTimeMap5to10s() { return putMessageDistributeTimeMap5to10s; }
    public int getPutMessageDistributeTimeMap10toMore() { return putMessageDistributeTimeMap10toMore; }
    public long getPullThreadPoolQueueCapacity() { return pullThreadPoolQueueCapacity; }
    public long getSendThreadPoolQueueCapacity() { return sendThreadPoolQueueCapacity; }
    public long getPullThreadPoolQueueSize() { return pullThreadPoolQueueSize; }
    public long getQueryThreadPoolQueueSize() { return queryThreadPoolQueueSize; }
    public long getPullThreadPoolQueueHeadWaitTimeMills() { return pullThreadPoolQueueHeadWaitTimeMills; }
    public long getQueryThreadPoolQueueHeadWaitTimeMills() { return queryThreadPoolQueueHeadWaitTimeMills; }
    public long getSendThreadPoolQueueHeadWaitTimeMills() { return sendThreadPoolQueueHeadWaitTimeMills; }
    public double getCommitLogDirCapacityFree() { return commitLogDirCapacityFree; }
    public double getCommitLogDirCapacityTotal() { return commitLogDirCapacityTotal; }
    public double getRemainHowManyDataToFlush() { return remainHowManyDataToFlush; }
    public double getGetFoundTps600() { return getFoundTps600; }
    public double getGetFoundTps60() { return getFoundTps60; }
    public double getGetFoundTps10() { return getFoundTps10; }
    public double getGetTotalTps600() { return getTotalTps600; }
    public double getGetTotalTps60() { return getTotalTps60; }
    public double getGetTotalTps10() { return getTotalTps10; }
    public double getGetTransferedTps600() { return getTransferedTps600; }
    public double getGetTransferedTps60() { return getTransferedTps60; }
    public double getGetTransferedTps10() { return getTransferedTps10; }
    public double getGetMissTps600() { return getMissTps600; }
    public double getGetMissTps60() { return getMissTps60; }
    public double getGetMissTps10() { return getMissTps10; }
    public double getPutTps600() { return putTps600; }
    public double getPutTps60() { return putTps60; }
    public double getPutTps10() { return putTps10; }
    public String getBrokerVersionDesc() { return brokerVersionDesc; }
    public long getBootTimestamp() { return bootTimestamp; }
    public double getBrokerVersion() { return brokerVersion; }
}
