package com.zzp.nacos.jobs;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description xxl-job-test
 * @Author karyzeng
 * @since 2020.11.14
 **/
@Component
public class XxlTestJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @XxlJob("helloWorld")
    public void helloWorld() {
        logger.info("你好，hello world");
        XxlJobHelper.log("你好，hello world");
    }

}
