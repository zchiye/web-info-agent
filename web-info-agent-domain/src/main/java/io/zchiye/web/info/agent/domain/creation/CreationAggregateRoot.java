package io.zchiye.web.info.agent.domain.creation;

import io.zchiye.web.info.agent.domain.interaction.InteractionStatEntity;
import io.zchiye.web.info.agent.domain.participant.ParticipantEntity;
import io.zchiye.web.info.agent.domain.resource.ResourceEntity;
import io.zchiye.web.info.agent.domain.tag.TagEntity;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class CreationAggregateRoot {

    private CreationEntity creation;

    private List<ParticipantEntity> participantList;

    private List<ResourceEntity> resourceList;

    private List<TagEntity> tagList;

    private InteractionStatEntity interactionStat;

    public boolean valid() {
        return creation != null
                && CollectionUtils.isNotEmpty(participantList) && getMainParticipant() != null
                && CollectionUtils.isNotEmpty(resourceList);
    }

    public String getCreationId() {
        return creation.getCreationId();
    }

    public long getCreationTimestamp() {
        return creation.getCreateTimestamp();
    }

    public ParticipantEntity getMainParticipant() {
        return Optional.ofNullable(participantList).orElse(new ArrayList<>())
                .stream()
                .filter(ParticipantEntity::isMainParticipant)
                .findFirst()
                .orElse(null);
    }

    public String getMainParticipantId() {
        return getMainParticipant().getUniversalId();
    }

    public String getPreviewImgUrl() {
        return Optional.ofNullable(resourceList).orElse(new ArrayList<>())
                .stream()
                .filter(ResourceEntity::isImage)
                .min(Comparator.comparingInt(ResourceEntity::getSerial))
                .map(ResourceEntity::getUrl)
                .orElse(null);
    }

    public List<String> getRichTexts() {
        return Optional.ofNullable(resourceList).orElse(new ArrayList<>())
                .stream()
                .filter(ResourceEntity::isRichText)
                .sorted(Comparator.comparingInt(ResourceEntity::getSerial))
                .map(ResourceEntity::getContent)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

}
