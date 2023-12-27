package io.zchiye.web.info.agent.domain.page;

import io.zchiye.web.info.agent.domain.common.entity.UrlEntity;
import io.zchiye.web.info.agent.domain.common.enums.WebsiteEnum;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PageDomain {

    private UrlEntity urlEntity;

    private WebsiteEnum websiteEnum;


}
