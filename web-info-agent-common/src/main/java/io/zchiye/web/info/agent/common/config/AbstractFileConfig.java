package io.zchiye.web.info.agent.common.config;

import io.zchiye.web.info.agent.common.utils.JsonUtils;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;

@Slf4j
public abstract class AbstractFileConfig<T extends AbstractConfigData> {

    @Resource
    private FileConfigRegister fileConfigRegister;

    @Getter
    protected T configData;

    protected abstract String getPath();

    @PostConstruct
    protected void init() {
        fileConfigRegister.register(getPath(), content -> {
            Class<T> clazz = getGenericClass();
            T tempConfig = JsonUtils.fromJson(content, clazz);
            if (tempConfig != null) {
                configData = tempConfig;
            }
            if (configData == null) {
                try {
                    configData = clazz.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
            log.info("{} changed configData = {}", getClass().getSimpleName(), JsonUtils.toJson(configData));
        });
    }

    private Class<T> getGenericClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
