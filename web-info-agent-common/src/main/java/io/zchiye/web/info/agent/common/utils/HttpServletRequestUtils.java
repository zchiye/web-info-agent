package io.zchiye.web.info.agent.common.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequestUtils {

    public static Map<String, String> getAllHeadersMap(HttpServletRequest httpServletRequest) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNameEnumeration = httpServletRequest.getHeaderNames();
        while (headerNameEnumeration.hasMoreElements()) {
            String headerName = headerNameEnumeration.nextElement();
            String header = httpServletRequest.getHeader(headerName);
            headersMap.put(headerName, header);
        }
        return headersMap;
    }

}
