package io.zchiye.web.info.agent.common.log;

public enum LogLevel {
    KEYPOINT,
    REQUEST,
    DEBUG,
    ;

    public boolean largerThan(LogLevel logLevel) {
        return this.ordinal() >= logLevel.ordinal();
    }
}
