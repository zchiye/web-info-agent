package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceDTO implements Serializable {

    private String resourceId;

    private String resourceUrl;

    private String resourceType;

    private String resourceContent;

}
