package io.zchiye.web.info.agent.api.controller;

import io.zchiye.web.info.agent.common.log.LogLevel;
import io.zchiye.web.info.agent.common.pojo.request.Request;
import io.zchiye.web.info.agent.common.pojo.response.Response;
import io.zchiye.web.info.agent.common.utils.JsonUtils;
import io.zchiye.web.info.agent.service.config.DemoConfig;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoConfig demoConfig;

    @ResponseBody
    @GetMapping("/get-config")
    public Object getConfig(HttpServletRequest servletRequest) {
        Map<String, Object> result = new HashMap<>();
        result.put("demo-config", demoConfig.getConfigData());
        return result;
    }

    @ResponseBody
    @PostMapping("/test-extension")
    public Response<String> testExtension(HttpServletRequest servletRequest, @RequestBody Request request) {
        log.info("DemoController testExtension request = {}", JsonUtils.toJson(request));
        request.putLog(String.format("开始于%s", System.currentTimeMillis()), LogLevel.DEBUG);
        request.putLog("request", request, LogLevel.REQUEST);
        Response<String> response = Response.success(String.format("成功于%s", System.currentTimeMillis()));
        log.info("DemoController testExtension response = {}", JsonUtils.toJson(response));
        request.putLog("success", response.isSuccess(), LogLevel.KEYPOINT);
        return response;
    }

}
