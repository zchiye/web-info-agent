package io.zchiye.web.info.agent.common.utils;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Matcher;

public class RegexUtilsTest {

    @Test
    public void testMatchRawUrl() {
        List<String> testCases = Lists.newArrayList(
                "://i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "//i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "http://i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "https://i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "ftp://i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg@672w_378h_1c_!web-home-common-cover",
                "https://i1.hdslb.com/bfs/archive/87cc0b4bc96cb05c0fd6519fd757a16ae3bebe4a.jpg",
                "https://search.bilibili.com/all?keyword=%E9%A9%AC%E7%9D%A3%E5%B7%A5&from_source=webtop_search&spm_id_from=333.1007&search_source=3",
                "search.bilibili.com",
                "search.bilibili.com/",
                "//search.bilibili.com",
                "https://t.bilibili.com/?spm_id_from=333.1007.0.0"
        );
        for (String testCase : testCases) {
            System.out.println("testCase: " + testCase);
            Matcher matcher = RegexUtils.matchRawUrl(testCase);
            System.out.println("matches: " + matcher.matches());
            if (matcher.matches()) {
                System.out.println("matcher1: " + matcher.group(1));
                System.out.println("matcher2: " + matcher.group(2));
                System.out.println("matcher3: " + matcher.group(3));
                System.out.println("matcher4: " + matcher.group(4));
                System.out.println("matcher5: " + matcher.group(5));
            }
            System.out.println();
        }
    }
}
