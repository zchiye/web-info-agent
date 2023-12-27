package io.zchiye.web.info.agent.api.controller;

import io.zchiye.web.info.agent.common.pojo.response.Response;
import io.zchiye.web.info.agent.contract.request.ExtractAbstractRequest;
import io.zchiye.web.info.agent.contract.result.ExtractAbstractResult;
import io.zchiye.web.info.agent.service.extract.ExtractService;
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
    private ExtractService extractService;

    @ResponseBody
    @PostMapping("/get-abstract")
    public Response<ExtractAbstractResult> getAbstract(HttpServletRequest httpServletRequest,
                                                       @RequestBody ExtractAbstractRequest request) {
        // TODO
        if (StringUtils.isBlank(request.getUrl())) {
            throw new IllegalArgumentException("empty url");
        }

        return null;
    }

}
