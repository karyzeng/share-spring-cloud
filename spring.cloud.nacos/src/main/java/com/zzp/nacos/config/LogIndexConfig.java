package com.zzp.nacos.config;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * elasticsearch的日志索引配置
 * @author GaryZeng
 * @since 2020.12.14
 */
@Component
public class LogIndexConfig {

    @Autowired
    private Environment env;

    private String springCloudNacosIndex;

    public String getSpringCloudNacosIndex() {
        String appName = env.getProperty("spring.application.name");
        return appName + "-log-" + this.convertDateToString(new Date(), "yyyy-MM-dd");
    }

    public void setSpringCloudNacosIndex(String springCloudNacosIndex) {
        this.springCloudNacosIndex = springCloudNacosIndex;
    }

    private String convertDateToString(Date date, String pattern) {
        String dateStr = DateFormatUtils.format(date, pattern);
        return dateStr;
    }
}
