package io.zchiye.web.info.agent.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogHelper {

    private static final String DEFAULT_DELIMITER = "\n";

    public void info(Class<?> clazz, List<String> msgList, Throwable e) {
        Logger logger = LoggerFactory.getLogger(clazz);
        msgList.add(0, clazz.getSimpleName());
        String delimiter = DEFAULT_DELIMITER;
        if (e != null) {
            logger.info(String.join(delimiter, msgList), e);
        } else {
            logger.info(String.join(delimiter, msgList));
        }
    }

}
