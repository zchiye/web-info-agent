package io.zchiye.web.info.agent.api;

import io.zchiye.web.info.agent.common.CommonContext;
import io.zchiye.web.info.agent.service.ServiceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@Import(value = {
        CommonContext.class,
        ServiceContext.class
})
public class ApiContext {

    public static void main(String[] args) {
        SpringApplication.run(ApiContext.class, args);
        System.out.println("Hello, World!");
    }
}
