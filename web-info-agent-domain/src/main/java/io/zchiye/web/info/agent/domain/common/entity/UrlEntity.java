package io.zchiye.web.info.agent.domain.common.entity;

import io.zchiye.web.info.agent.common.utils.RegexUtils;
import io.zchiye.web.info.agent.common.utils.UrlUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;

@Getter
@AllArgsConstructor
public class UrlEntity implements Comparable<UrlEntity> {

    private static final String DEFAULT_PROTOCOL = "http";

    private String rawUrl;
    private String protocol = DEFAULT_PROTOCOL;
    private String websiteHostname;
    private String resourcePath;
    private String fileName;
    private String rawParams;
    private Map<String, String> params;
    private String atParam;

    public UrlEntity() {
        initializeCheck();
    }

    public UrlEntity(String rawUrl) {
        this.rawUrl = rawUrl;
        Matcher matcher = RegexUtils.matchRawUrl(rawUrl);
        if (matcher != null && matcher.matches()) {
            String protocol = matcher.group(1);
            String websiteHostname = matcher.group(3);
            String resourcePath = matcher.group(4);
            String rawParams = matcher.group(5);
            initialize(protocol, websiteHostname, resourcePath, rawParams);
        } else {
            initializeCheck();
        }
    }

    public void initialize(String protocol, String websiteHostname, String resourcePath, String rawParams) {
        this.protocol = protocol;
        this.websiteHostname = websiteHostname;
        this.resourcePath = resourcePath;
        if (StringUtils.isNotBlank(this.resourcePath)) {
            this.fileName = UrlUtils.getFileName(this.resourcePath);
        }
        this.rawParams = rawParams;
        if (StringUtils.isNotBlank(this.rawParams)) {
            if (this.rawParams.startsWith("@")) {
                this.atParam = UrlUtils.getAtParam(this.rawParams);
            } else if (this.rawParams.startsWith("?")) {
                this.params = UrlUtils.getParams(this.rawParams);
            }
        }
        initializeCheck();
    }

    private void initializeCheck() {
        if (StringUtils.isBlank(protocol)) {
            protocol = DEFAULT_PROTOCOL;
        }
        if (websiteHostname == null) {
            websiteHostname = "";
        }
        if (resourcePath == null) {
            resourcePath = "";
        }
        if (StringUtils.isBlank(rawUrl) && valid()) {
            rawUrl = toSimpleUrl();
        }
    }

    public String toSimpleUrl() {
        return protocol + "://" + websiteHostname + resourcePath;
    }

    public boolean valid() {
        return StringUtils.isNotBlank(websiteHostname);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UrlEntity another)) {
            return false;
        }
        return this.protocol.equals(another.protocol)
                && this.websiteHostname.equals(another.websiteHostname)
                && this.resourcePath.equals(another.resourcePath);
    }

    @Override
    public int hashCode() {
        return protocol.hashCode()
                ^ websiteHostname.hashCode()
                ^ resourcePath.hashCode();
    }

    @Override
    public int compareTo(UrlEntity o) {
        int compareProtocol = this.protocol.compareTo(o.protocol);
        if (compareProtocol != 0) {
            return compareProtocol;
        }
        int compareWebsiteUrl = this.websiteHostname.compareTo(o.websiteHostname);
        if (compareWebsiteUrl != 0) {
            return compareWebsiteUrl;
        }
        int compareResourceUrl = this.resourcePath.compareTo(o.resourcePath);
        if (compareResourceUrl != 0) {
            return compareResourceUrl;
        }
        return 0;
    }

}
