package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParticipantDTO implements Serializable {

    private String universalParticipantId;

    private String universalParticipantName;

    private String platformParticipantId;

    private String platformParticipantName;

    private String platformParticipantIntro;

    private String platformFollowerCount;

    private String avatarUrl;

}
