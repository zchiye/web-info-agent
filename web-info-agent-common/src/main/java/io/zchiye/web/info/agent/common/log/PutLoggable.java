package io.zchiye.web.info.agent.common.log;

public interface PutLoggable extends Loggable {

    void putLog(String logMsg, LogLevel logLevel);

    void putLog(String logKey, Object logValue, LogLevel logLevel);
}
