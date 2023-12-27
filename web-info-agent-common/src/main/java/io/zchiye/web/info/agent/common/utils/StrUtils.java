package io.zchiye.web.info.agent.common.utils;

import org.apache.commons.lang3.StringUtils;

public class StrUtils {

    /**
     * 返回输入字符串的最后一个标识字符出现处之后的子串
     * @param str 输入字符串
     * @param character 标识字符
     * @return 如果没有标识字符返回原字符串
     */
    public static String getStrBehindLastChar(String str, Character character) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int idx = str.lastIndexOf(character);
        if (idx < 0) {
            return str;
        }
        return str.substring(idx + 1);
    }

    /**
     * 返回输入字符串的第一个标识字符出现处之后的子串
     * @param str 输入字符串
     * @param character 标识字符
     * @return 如果没有标识字符返回null
     */
    public static String getStrBehindFirstChar(String str, Character character) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int idx = str.indexOf(character);
        if (idx < 0) {
            return null;
        }
        return str.substring(idx + 1);
    }

}
