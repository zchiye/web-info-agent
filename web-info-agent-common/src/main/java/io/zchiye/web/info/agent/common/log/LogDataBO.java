package io.zchiye.web.info.agent.common.log;

import io.zchiye.web.info.agent.common.utils.JsonUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogDataBO {

    private final List<Pair<LogLevel, String>> flowLogList = new ArrayList<>();
    private final Map<String, Pair<LogLevel, Object>> dataLogMap = new HashMap<>();

    public void putLog(String msg, LogLevel logLevel) {
        synchronized (flowLogList) {
            flowLogList.add(Pair.of(logLevel, msg));
        }
    }

    public void putLog(String logKey, Object logValue, LogLevel logLevel) {
        synchronized (dataLogMap) {
            dataLogMap.put(logKey, Pair.of(logLevel, logValue));
        }
    }

    public List<String> getLog(LogLevel logLevel) {
        List<String> logList = new ArrayList<>();
        logList.add("【FLOW】");
        List<String> flowLog = flowLogList.stream()
                .filter(p -> logLevel.largerThan(p.getKey()))
                .map(Pair::getValue)
                .collect(Collectors.toList());
        logList.add(JsonUtils.toJson(flowLog));
        logList.add("【DATA】");
        Map<String, Object> dataLog = dataLogMap.entrySet().stream()
                .filter(e -> logLevel.largerThan(e.getValue().getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getValue()));
        logList.add(JsonUtils.toJson(dataLog));
        return logList;
    }
}
