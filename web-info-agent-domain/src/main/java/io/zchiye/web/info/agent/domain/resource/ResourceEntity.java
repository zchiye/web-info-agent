package io.zchiye.web.info.agent.domain.resource;

import io.zchiye.web.info.agent.domain.resource.enums.ResourceTypeEnum;
import lombok.Data;

@Data
public class ResourceEntity {

    private ResourceTypeEnum resourceTypeEnum;

    private String resourceId;

    private int serial;

    private String url;

    private String content;

    public boolean isImage() {
        return ResourceTypeEnum.IMAGE.equals(resourceTypeEnum);
    }

    public boolean isRichText() {
        return ResourceTypeEnum.RICH_TEXT.equals(resourceTypeEnum);
    }

}
