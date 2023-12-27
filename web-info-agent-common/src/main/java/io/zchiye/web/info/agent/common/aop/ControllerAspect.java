package io.zchiye.web.info.agent.common.aop;

import io.zchiye.web.info.agent.common.log.LogHelper;
import io.zchiye.web.info.agent.common.log.LogLevel;
import io.zchiye.web.info.agent.common.pojo.request.LogHttpServletRequest;
import io.zchiye.web.info.agent.common.pojo.request.Request;
import io.zchiye.web.info.agent.common.pojo.response.Response;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class ControllerAspect {

    @Resource
    private LogHelper logHelper;

    // 定义切点，匹配所有被 @Controller 或 @RestController 注解的类
    @Pointcut("@within(org.springframework.stereotype.Controller) " +
            "|| @within(org.springframework.web.bind.annotation.RestController)")
    public void controllerPointcut() {

    }

    @Around("controllerPointcut()")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Throwable e = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            e = throwable;
        }
        Object[] args = joinPoint.getArgs();
        LogHttpServletRequest logHttpServletRequest = Arrays.stream(args)
                .filter(arg -> arg instanceof HttpServletRequest)
                .map(arg -> new LogHttpServletRequest((HttpServletRequest) arg))
                .findFirst()
                .orElse(null);
        Request request = Arrays.stream(args)
                .filter(arg -> arg instanceof Request)
                .map(arg -> (Request) arg)
                .findFirst()
                .orElse(null);
        Response<?> response = result instanceof Response ? (Response<?>) result : null;
        logController(joinPoint.getTarget().getClass(), logHttpServletRequest, request, response, e);
        return result;
    }

    private void logController(Class<?> clazz, LogHttpServletRequest logHttpServletRequest, Request request,
                               Response<?> response, Throwable throwable) {
        LogLevel logLevel = throwable != null ? LogLevel.DEBUG : LogLevel.KEYPOINT;
        if (response != null && !response.isSuccess()) {
            logLevel = LogLevel.DEBUG;
        }
        List<String> msgList = new ArrayList<>();
        if (logHttpServletRequest != null) {
            msgList.addAll(logHttpServletRequest.getLog(logLevel));
        }
        if (request != null) {
            msgList.addAll(request.getLog(logLevel));
        }
        if (response != null) {
            msgList.addAll(response.getLog(logLevel));
        }
        logHelper.info(clazz, msgList, throwable);
    }

}
