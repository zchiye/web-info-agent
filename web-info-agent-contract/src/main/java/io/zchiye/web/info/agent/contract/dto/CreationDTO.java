package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreationDTO implements Serializable {

    private String creationId;

    private String mainParticipantId;

    private List<String> richTexts;

    private Long createTimestamp;

    private String createDate;

}
