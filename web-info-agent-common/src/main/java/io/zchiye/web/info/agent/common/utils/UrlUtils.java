package io.zchiye.web.info.agent.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class UrlUtils {

    public static String getFileName(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        return StrUtils.getStrBehindLastChar(filePath, '/');
    }

    public static String getAtParam(String rawParams) {
        if (StringUtils.isBlank(rawParams)) {
            return null;
        }
        return StrUtils.getStrBehindFirstChar(rawParams, '@');
    }

    public static Map<String, String> getParams(String rawParams) {
        if (StringUtils.isBlank(rawParams)) {
            return null;
        }
        String paramsStr = StrUtils.getStrBehindFirstChar(rawParams, '?');
        if (StringUtils.isBlank(paramsStr)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        for (String param : paramsStr.split("&")) {
            String[] parts = param.split("=");
            if (parts.length < 2) {
                continue;
            }
            String key = parts[0];
            String value = parts[1];
            params.put(key, value);
        }
        return params;
    }

}
