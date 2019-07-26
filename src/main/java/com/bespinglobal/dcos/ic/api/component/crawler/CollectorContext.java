package com.bespinglobal.dcos.ic.api.component.crawler;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.component.crawler.CollectorContext
 * Version : 2019.07.24 v0.1
 * Created by taehyoung.yim on 2019-07-24.
 * *** 저작권 주의 ***
 */
public class CollectorContext {

    private DbCrawlerStrategy dbCrawlerStrategy;

    public CollectorContext(DbCrawlerStrategy dbCrawlerStrategy) {
        this.dbCrawlerStrategy = dbCrawlerStrategy;
    }

    public String crawling() {
        return dbCrawlerStrategy.crawling();
    }
}
