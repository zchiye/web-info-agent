package io.zchiye.web.info.agent.service.extract.context;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ExtractAbstractContext {

    private String rawUrl;

    private Map<String, String> headers;

}
