package com.bespinglobal.dcos.ic.api.component;

import org.springframework.stereotype.Component;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.component.GcpAssetDbCrawler
 * Version : 2019.07.25 v0.1
 * Created by taehyoung.yim on 2019-07-25.
 * *** 저작권 주의 ***
 */
@Component
public class GcpAssetDbCrawler implements DbCrawlerStrategy {

    @Override
    public String crawling() {
        return "crawling asset data on GCP from the OpsNow's database";
    }
}
