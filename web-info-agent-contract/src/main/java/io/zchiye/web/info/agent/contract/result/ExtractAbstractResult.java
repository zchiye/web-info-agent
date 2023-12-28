package io.zchiye.web.info.agent.contract.result;

import io.zchiye.web.info.agent.contract.dto.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExtractAbstractResult implements Serializable {

    private CreationDTO creationDTO;

    private List<ResourceDTO> resourceDTOList;

    private List<ParticipantDTO> participantDTOList;

    private InteractionDTO interactionDTO;

    private List<TagDTO> tagDTOList;

}
