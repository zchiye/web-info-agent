package io.zchiye.web.info.agent.contract.request;

import io.zchiye.web.info.agent.common.pojo.request.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExtractAbstractRequest extends Request {

    private String url;

    private Map<String, String> headers;

}
