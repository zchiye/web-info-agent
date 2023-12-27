package io.zchiye.web.info.agent.common.log;

import java.util.List;

public interface Loggable {

    void putLog(String logMsg, LogLevel logLevel);

    void putLog(String logKey, Object logValue, LogLevel logLevel);

    List<String> getLog(LogLevel logLevel);
}
