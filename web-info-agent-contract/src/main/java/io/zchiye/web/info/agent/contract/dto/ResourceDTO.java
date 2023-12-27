package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceDTO implements Serializable {

    private String resourceUrl;

    private Integer resourceType;

    private String resourceContent;

}
