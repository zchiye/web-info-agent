package io.zchiye.web.info.agent.domain.page;

import com.google.common.base.MoreObjects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.zchiye.web.info.agent.common.config.AbstractConfigData;
import io.zchiye.web.info.agent.common.config.AbstractFileConfig;
import io.zchiye.web.info.agent.domain.common.enums.WebsiteEnum;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class PageDomainConfig extends AbstractFileConfig<PageDomainConfig.ConfigData> {

    private volatile Cache<Integer, List<Pattern>> websiteRePatternsCache;

    @Override
    protected String getPath() {
        return "domain/page-domain-config.json";
    }

    @Override
    @PostConstruct
    public void init() {
        super.init();
        if (configData == null) {
            return;
        }
        initRePatterns();
    }

    private void initRePatterns() {
        if (MapUtils.isEmpty(configData.websitePatternsMap)) {
            return;
        }
        Cache<Integer, List<Pattern>> tempCache = CacheBuilder.newBuilder().build();
        configData.websitePatternsMap.forEach((websiteCode, patterns) -> {
            if (CollectionUtils.isEmpty(patterns)) {
                return;
            }
            List<Pattern> rePatterns = MoreObjects.firstNonNull(tempCache.getIfPresent(websiteCode), new ArrayList<>());
            patterns.forEach(patternStr -> rePatterns.add(Pattern.compile(patternStr)));
            tempCache.put(websiteCode, rePatterns);
        });
        websiteRePatternsCache = tempCache;
    }

    @Getter
    public static class ConfigData extends AbstractConfigData {
        private Map<Integer, List<String>> websitePatternsMap;
    }

    public WebsiteEnum matchUrlWebsite(String url) {
        // TODO
        return null;
    }
}
