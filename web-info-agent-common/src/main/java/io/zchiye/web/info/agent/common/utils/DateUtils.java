package io.zchiye.web.info.agent.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DEFAULT_DATE_MILLIS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static String formatDateMillis(long timestamp) {
        return DEFAULT_DATE_MILLIS_FORMAT.format(new Date(timestamp));
    }

}
