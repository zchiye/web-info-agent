package io.zchiye.web.info.agent.common.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.zchiye.web.info.agent.common.log.LogDataBO;
import io.zchiye.web.info.agent.common.log.LogLevel;
import io.zchiye.web.info.agent.common.log.Loggable;
import io.zchiye.web.info.agent.common.utils.JsonUtils;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class Request implements Serializable, Loggable {

    private final long clientTimeMs = System.currentTimeMillis();

    private Map<String, Object> transData;

    @JsonIgnore
    private final transient LogDataBO logDataBO = new LogDataBO();

    @Override
    public void putLog(String logMsg, LogLevel logLevel) {
        logDataBO.putLog(logMsg, logLevel);
    }

    @Override
    public void putLog(String logKey, Object logValue, LogLevel logLevel) {
        logDataBO.putLog(logKey, logValue, logLevel);
    }

    @Override
    public List<String> getLog(LogLevel logLevel) {
        List<String> msgList = new ArrayList<>();
        if (logLevel.largerThan(LogLevel.REQUEST)) {
            msgList.add("【REQUEST】");
            msgList.add(JsonUtils.toJson(this));
        }
        msgList.addAll(logDataBO.getLog(logLevel));
        return msgList;
    }
}
