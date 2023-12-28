package io.zchiye.web.info.agent.domain.participant.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {

    DEFAULT_ROLE(0, "未分类角色"),
    MAIN_CREATOR(1, "主要创作者"),
    SUB_CREATOR(2, "次要创作者"),
    PUBLISHER(3, "发布者"),
    ;

    private Integer code;
    private String desc;

    RoleEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RoleEnum getByCode(Integer code) {
        for (RoleEnum roleEnum : values()) {
            if (roleEnum.code.equals(code)) {
                return roleEnum;
            }
        }
        return DEFAULT_ROLE;
    }

}
