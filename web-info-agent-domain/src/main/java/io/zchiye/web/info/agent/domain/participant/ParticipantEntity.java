package io.zchiye.web.info.agent.domain.participant;

import io.zchiye.web.info.agent.domain.participant.enums.RoleEnum;
import lombok.Data;

@Data
public class ParticipantEntity {

    private String universalId;

    private String universalName;

    private String curPlatform;

    private String platformId;

    private String platformName;

    private String platformAvatarUrl;

    private String platformIntro;

    private Long platformFollowerCount;

    private RoleEnum roleEnum;

    public boolean isMainParticipant() {
        return roleEnum == RoleEnum.MAIN_CREATOR;
    }

}
