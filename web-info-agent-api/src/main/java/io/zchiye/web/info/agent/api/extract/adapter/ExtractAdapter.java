package io.zchiye.web.info.agent.api.extract.adapter;

import io.zchiye.web.info.agent.contract.dto.*;
import io.zchiye.web.info.agent.contract.request.ExtractAbstractRequest;
import io.zchiye.web.info.agent.contract.result.ExtractAbstractResult;
import io.zchiye.web.info.agent.domain.creation.CreationAggregateRoot;
import io.zchiye.web.info.agent.service.extract.ExtractService;
import io.zchiye.web.info.agent.service.extract.context.ExtractAbstractContext;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtractAdapter {

    @Resource
    private ExtractService extractService;

    public ExtractAbstractResult getPageAbstract(ExtractAbstractRequest extractAbstractRequest) {
        ExtractAbstractContext context = ExtractAbstractContext.builder()
                .rawUrl(extractAbstractRequest.getPageUrl())
                .headers(extractAbstractRequest.getPageHeaders())
                .build();
        CreationAggregateRoot creationAggregateRoot = extractService.extractCreationAbstract(context);
        return convertToExtractAbstractResult(creationAggregateRoot);
    }

    private static ExtractAbstractResult convertToExtractAbstractResult(CreationAggregateRoot creationAggregateRoot) {
        if (creationAggregateRoot == null || !creationAggregateRoot.valid()) {
            return null;
        }
        ExtractAbstractResult result = new ExtractAbstractResult();
        result.setCreationDTO(convertToCreationDTO(creationAggregateRoot));
        result.setParticipantDTOList(convertToParticipantDTOList(creationAggregateRoot));
        result.setResourceDTOList(convertToResourceDTOList(creationAggregateRoot));
        result.setTagDTOList(convertToTagDTOList(creationAggregateRoot));
        result.setInteractionDTO(convertToInteractionDTO(creationAggregateRoot));
        return result;
    }

    private static CreationDTO convertToCreationDTO(CreationAggregateRoot creationAggregateRoot) {
        if (creationAggregateRoot == null || !creationAggregateRoot.valid()) {
            return null;
        }
        CreationDTO creationDTO = new CreationDTO();
        BeanUtils.copyProperties(creationAggregateRoot, creationDTO);
        return creationDTO;
    }

    private static List<ParticipantDTO> convertToParticipantDTOList(CreationAggregateRoot creationAggregateRoot) {
        // TODO
        return null;
    }

    private static List<ResourceDTO> convertToResourceDTOList(CreationAggregateRoot creationAggregateRoot) {
        // TODO
        return null;
    }

    private static List<TagDTO> convertToTagDTOList(CreationAggregateRoot creationAggregateRoot) {
        // TODO
        return null;
    }

    private static InteractionDTO convertToInteractionDTO(CreationAggregateRoot creationAggregateRoot) {
        // TODO
        return null;
    }

}
