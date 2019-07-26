package com.bespinglobal.dcos.ic.api.service.crawler;

import com.bespinglobal.dcos.ic.api.component.crawler.AccountDbCrawler;
import com.bespinglobal.dcos.ic.api.component.crawler.AwsAssetDbCrawler;
import com.bespinglobal.dcos.ic.api.component.crawler.CollectorContext;
import com.bespinglobal.dcos.ic.api.component.crawler.GcpAssetDbCrawler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Project : Information-Collector
 * Class : com.bespinglobal.dcos.ic.api.service.crawler.AssetServiceImplTest
 * Version :
 * Created by taehyoung.yim on 2019-07-25.
 * *** 저작권 주의 ***
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetServiceImplTest {

    private CollectorContext awsDbCollector;
    private CollectorContext gcpCollector;
    private CollectorContext accountDbCollector;

    @Before
    public void setUp() {
        this.awsDbCollector = new CollectorContext(new AwsAssetDbCrawler());
        this.gcpCollector = new CollectorContext(new GcpAssetDbCrawler());
        this.accountDbCollector = new CollectorContext(new AccountDbCrawler());
    }

    @Test
    public void a1_conform_strategy_pattern() {

        // when
        String result = awsDbCollector.crawling();

        // then
        checkTheResult(result, "crawling asset data on AWS from the OpsNow's database");
    }

    @Test
    public void a2_conform_strategty_pattern() {

        // when
        String result = gcpCollector.crawling();

        // then
        checkTheResult(result, "crawling asset data on GCP from the OpsNow's database");
    }

    @Test
    public void a3_conform_strategy_pattern() {

        // when
        String result = accountDbCollector.crawling();

        // then
        checkTheResult(result, "crawling account data from the Portal's database");
    }

    private void checkTheResult(String result, String expected) {

        assertThat(result, is(notNullValue()));
        assertThat(result, is(expected));
    }
}