package io.zchiye.web.info.agent.domain.creation;

import lombok.Data;

@Data
public class CreationEntity {

    private String creationId;

    private String mainParticipantId;

    private long createTimestamp;

}
