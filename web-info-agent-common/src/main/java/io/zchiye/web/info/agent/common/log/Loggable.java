package io.zchiye.web.info.agent.common.log;

import java.util.List;

public interface Loggable {

    List<String> getLog(LogLevel logLevel);
}
