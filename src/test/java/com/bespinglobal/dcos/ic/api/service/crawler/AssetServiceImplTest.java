package com.bespinglobal.dcos.ic.api.service.crawler;

import com.bespinglobal.dcos.ic.api.component.AccountDbCrawler;
import com.bespinglobal.dcos.ic.api.component.AwsAssetDbCrawler;
import com.bespinglobal.dcos.ic.api.component.CollectorContext;
import com.bespinglobal.dcos.ic.api.component.GcpAssetDbCrawler;
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

    private CollectorContext awsAssetDbCollector;
    private CollectorContext gcpAssetDbCollector;
    private CollectorContext accountDbCollector;

    @Before
    public void setUp() {
        this.awsAssetDbCollector = new CollectorContext(new AwsAssetDbCrawler());
        this.gcpAssetDbCollector = new CollectorContext(new GcpAssetDbCrawler());
        this.accountDbCollector = new CollectorContext(new AccountDbCrawler());
    }

    @Test
    public void a1_conform_strategy_pattern() {

        // when
        String result = awsAssetDbCollector.crawling();

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result, is("crawling asset data on AWS from the OpsNow's database"));
    }

    @Test
    public void a2_conform_strategty_pattern() {

        // when
        String result = gcpAssetDbCollector.crawling();

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result, is("crawling asset data on GCP from the OpsNow's database"));
    }

    @Test
    public void a3_conform_strategy_pattern() {

        // when
        String result = accountDbCollector.crawling();

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result, is("crawling account data from the Portal's database"));
    }
}