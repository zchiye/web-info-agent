package io.zchiye.web.info.agent.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    private static final Pattern RAW_URL_PATTERN = Pattern.compile("^(https?|ftp)?(:?//)?([^/]+)(/?[^@?]+)?([@?].*)?$");

    public static Matcher matchRawUrl(String rawUrl) {
        if (rawUrl == null) {
            return null;
        }
        return RAW_URL_PATTERN.matcher(rawUrl);
    }

}
