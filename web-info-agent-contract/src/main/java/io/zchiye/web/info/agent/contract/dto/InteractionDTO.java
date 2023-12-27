package io.zchiye.web.info.agent.contract.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InteractionDTO implements Serializable {

    private Long likeCount;

    private Long favCount;

    private Long repostCount;

    private Long commentCount;

}
