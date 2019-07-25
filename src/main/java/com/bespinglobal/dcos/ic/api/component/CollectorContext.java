package com.bespinglobal.dcos.ic.api.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.component.CollectorContext
 * Version : 2019.07.24 v0.1
 * Created by taehyoung.yim on 2019-07-24.
 * *** 저작권 주의 ***
 */
@Getter
@Setter
public class CollectorContext {

    private DbCrawlerStrategy crawlerStrategy;

    public CollectorContext(DbCrawlerStrategy crawlerStrategy) {
        this.crawlerStrategy = crawlerStrategy;
    }

    public String crawling() {
        return crawlerStrategy.crawling();
    }
}
