package com.bespinglobal.dcos.ic.api.service.crawler;

import com.bespinglobal.dcos.ic.api.component.AccountDbCrawler;
import com.bespinglobal.dcos.ic.api.component.AssetDbCrawler;
import com.bespinglobal.dcos.ic.api.component.CollectorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.service.crawler.CrawlerServiceImpl
 * Version : 2019.07.25 v0.1
 * Created by taehyoung.yim on 2019-07-25.
 * *** 저작권 주의 ***
 */
@Service
public class AssetServiceImpl implements AssetService {

    private static final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

    private CollectorContext assetDbCollector;
    private CollectorContext accountDbCollector;

    public AssetServiceImpl() {
        this.assetDbCollector = new CollectorContext(new AssetDbCrawler());
        this.accountDbCollector = new CollectorContext(new AccountDbCrawler());
    }

    @Override
    public void crawlingAssetDataByService() {

        logger.info(assetDbCollector.crawling());
    }

    @Override
    public void crawlingAllAccountData() {

        logger.info(accountDbCollector.crawling());
    }
}
