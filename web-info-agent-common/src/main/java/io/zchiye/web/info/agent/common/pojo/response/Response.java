package io.zchiye.web.info.agent.common.pojo.response;

import io.zchiye.web.info.agent.common.log.LogLevel;
import io.zchiye.web.info.agent.common.log.Loggable;
import io.zchiye.web.info.agent.common.utils.JsonUtils;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class Response<T> implements Serializable, Loggable {

    private boolean success;

    private T result;

    public static <T> Response<T> success(T result) {
        Response<T> response = new Response<>();
        response.success = true;
        response.result = result;
        return response;
    }

    @Override
    public List<String> getLog(LogLevel logLevel) {
        return List.of(
                "【RESPONSE】",
                JsonUtils.toJson(this)
        );
    }
}
