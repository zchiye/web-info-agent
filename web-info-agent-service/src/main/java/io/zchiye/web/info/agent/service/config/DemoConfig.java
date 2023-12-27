package io.zchiye.web.info.agent.service.config;

import io.zchiye.web.info.agent.common.config.AbstractConfigData;
import io.zchiye.web.info.agent.common.config.AbstractFileConfig;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class DemoConfig extends AbstractFileConfig<DemoConfig.ConfigData> {

    @Override
    protected String getPath() {
        return "demo-config-1.json";
    }

    @Getter
    public static class ConfigData extends AbstractConfigData {
        private int testInt;
        private Integer testInteger;
        private String testString;
        private List<String> testStringList;
        private Map<String, ConfigObject> testObjectMap;
        private Set<String> testDefaultSet = Set.of("testSetItem1", "testSetItem2");
    }

    @Getter
    private static class ConfigObject {
        private double testDouble;
        private Float testFloat;
    }
}
