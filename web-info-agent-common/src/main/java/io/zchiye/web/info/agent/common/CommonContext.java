package io.zchiye.web.info.agent.common;

import io.zchiye.web.info.agent.common.config.FileConfigRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CommonContext {

    @Bean
    public FileConfigRegister fileConfigRegister() {
        return new FileConfigRegister(1000L, "configs");
    }
}
