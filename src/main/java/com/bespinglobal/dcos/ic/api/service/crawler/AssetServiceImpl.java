package com.bespinglobal.dcos.ic.api.service.crawler;

import com.bespinglobal.dcos.ic.api.component.crawler.AccountDbCrawler;
import com.bespinglobal.dcos.ic.api.component.crawler.CollectorContext;
import com.bespinglobal.dcos.ic.api.component.crawler.AwsAssetDbCrawler;
import com.bespinglobal.dcos.ic.api.component.crawler.GcpAssetDbCrawler;
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

    private CollectorContext awsCollector;
    private CollectorContext gcpCollector;
    private CollectorContext accountDbCollector;

    public AssetServiceImpl() {
        this.awsCollector = new CollectorContext(new AwsAssetDbCrawler());
        this.gcpCollector = new CollectorContext(new GcpAssetDbCrawler());
        this.accountDbCollector = new CollectorContext(new AccountDbCrawler());
    }

    @Override
    public void crawlingAwsDataByService() {

        logger.info(awsCollector.crawling());
    }

    @Override
    public void crawlingAwsAccountDataByService() {

        logger.info(gcpCollector.crawling());
    }


    @Override
    public void crawlingAllAccountData() {

        logger.info(accountDbCollector.crawling());
    }
}
