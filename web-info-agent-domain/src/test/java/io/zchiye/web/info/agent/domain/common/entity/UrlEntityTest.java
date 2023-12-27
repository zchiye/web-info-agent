package io.zchiye.web.info.agent.domain.common.entity;

import io.zchiye.web.info.agent.common.utils.JsonUtils;
import org.junit.jupiter.api.Test;

public class UrlEntityTest {

    @Test
    public void testUrlEntity1() {
        UrlEntity testUrlEntity = new UrlEntity("//i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover");
        System.out.println(JsonUtils.toJson(testUrlEntity));
        UrlEntity standardUrlEntity = new UrlEntity();
        standardUrlEntity.initialize("http", "i1.hdslb.com", "/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg", null);
        System.out.println(JsonUtils.toJson(standardUrlEntity));
        assert standardUrlEntity.equals(testUrlEntity);
        System.out.println(testUrlEntity.toSimpleUrl());
    }

    @Test
    public void testUrlEntity2() {
        UrlEntity testUrlEntity = new UrlEntity("https://search.bilibili.com/all?keyword=%E9%A9%AC%E7%9D%A3%E5%B7%A5&from_source=webtop_search&spm_id_from=333.1007&search_source=3");
        System.out.println(JsonUtils.toJson(testUrlEntity));
        UrlEntity standardUrlEntity = new UrlEntity();
        standardUrlEntity.initialize("https", "search.bilibili.com", "/all", "keyword=%E9%A9%AC%E7%9D%A3%E5%B7%A5&from_source=webtop_search&spm_id_from=333.1007&search_source=3");
        System.out.println(JsonUtils.toJson(standardUrlEntity));
        assert standardUrlEntity.equals(testUrlEntity);
        System.out.println(testUrlEntity.toSimpleUrl());
    }

}
