package io.zchiye.web.info.agent.api.extract.controller;

import io.zchiye.web.info.agent.api.extract.adapter.ExtractAdapter;
import io.zchiye.web.info.agent.common.pojo.response.Response;
import io.zchiye.web.info.agent.contract.request.ExtractAbstractRequest;
import io.zchiye.web.info.agent.contract.result.ExtractAbstractResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/extract")
public class ExtractController {

    @Resource
    private ExtractAdapter extractAdapter;

    @ResponseBody
    @PostMapping("/get-page-abstract")
    public Response<ExtractAbstractResult> getPageAbstract(HttpServletRequest httpServletRequest,
                                                       @RequestBody ExtractAbstractRequest request) {
        if (StringUtils.isBlank(request.getPageUrl())) {
            throw new IllegalArgumentException("empty url");
        }
        ExtractAbstractResult result = extractAdapter.getPageAbstract(request);
        return Response.success(result);
    }

}
