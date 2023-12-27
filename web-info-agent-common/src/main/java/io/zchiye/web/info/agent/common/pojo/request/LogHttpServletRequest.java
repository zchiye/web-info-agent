package io.zchiye.web.info.agent.common.pojo.request;

import com.google.common.collect.Lists;
import io.zchiye.web.info.agent.common.log.LogLevel;
import io.zchiye.web.info.agent.common.log.Loggable;
import io.zchiye.web.info.agent.common.utils.HttpServletRequestUtils;
import io.zchiye.web.info.agent.common.utils.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

public class LogHttpServletRequest implements Loggable {
    
    private HttpServletRequest httpServletRequest;
    
    public LogHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    
    @Override
    public void putLog(String logMsg, LogLevel logLevel) {
        
    }

    @Override
    public void putLog(String logKey, Object logValue, LogLevel logLevel) {

    }

    @Override
    public List<String> getLog(LogLevel logLevel) {
        String path = httpServletRequest.getServletPath();
        List<String> msgList = Lists.newArrayList(
                "【PATH】",
                path
        );
        if (logLevel.largerThan(LogLevel.REQUEST)) {
            Map<String, String> headers = HttpServletRequestUtils.getAllHeadersMap(httpServletRequest);
            msgList.add("【HEADERS】");
            msgList.add(JsonUtils.toJson(headers));
        }
        return msgList;
    }
}
