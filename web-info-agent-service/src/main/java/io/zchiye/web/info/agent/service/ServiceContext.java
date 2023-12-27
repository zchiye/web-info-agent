package io.zchiye.web.info.agent.service;

import io.zchiye.web.info.agent.common.CommonContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
@Import(value = {
        CommonContext.class
})
public class ServiceContext {

}
