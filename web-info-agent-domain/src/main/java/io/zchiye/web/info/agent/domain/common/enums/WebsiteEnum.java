package io.zchiye.web.info.agent.domain.common.enums;

import lombok.Getter;

@Getter
public enum WebsiteEnum {
    BILIBILI(1, "bilibili", "B站"),
    WEIBO(1, "weibo", "微博"),
    TWITTER(3, "twitter", "推特"),
    PIXIV(4, "pixiv", "P站"),
    ;

    private int code;
    private String name;
    private String desc;
    WebsiteEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }
}
