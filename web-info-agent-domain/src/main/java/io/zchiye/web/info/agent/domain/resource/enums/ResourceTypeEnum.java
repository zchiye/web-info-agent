package io.zchiye.web.info.agent.domain.resource.enums;

import lombok.Getter;

@Getter
public enum ResourceTypeEnum {

    DEFAULT_TYPE(0, "未分类资源"),
    IMAGE(1, "图片"),
    GIF(2, "动态图"),
    RICH_TEXT(3, "富文本"),
    VIDEO(4, "视频"),
    ;

    private Integer code;
    private String desc;

    ResourceTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResourceTypeEnum getByCode(Integer code) {
        for (ResourceTypeEnum resourceTypeEnum : values()) {
            if (resourceTypeEnum.code.equals(code)) {
                return resourceTypeEnum;
            }
        }
        return DEFAULT_TYPE;
    }

}
