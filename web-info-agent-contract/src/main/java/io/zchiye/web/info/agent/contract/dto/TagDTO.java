package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagDTO implements Serializable {

    private String tagId;

    private String tagName;

    private String tagUrl;

}
