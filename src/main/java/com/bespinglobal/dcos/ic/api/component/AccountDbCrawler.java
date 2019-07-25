package com.bespinglobal.dcos.ic.api.component;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.component.AccountDbCrawler
 * Version : 2019.07.25 v0.1
 * Created by taehyoung.yim on 2019-07-25.
 * *** 저작권 주의 ***
 */
public class AccountDbCrawler implements DbCrawlerStrategy {

    @Override
    public String crawling() {
        return "crawling account data from the Portal's database";
    }
}
