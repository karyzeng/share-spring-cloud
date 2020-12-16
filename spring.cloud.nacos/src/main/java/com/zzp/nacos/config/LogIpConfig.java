package com.zzp.nacos.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description logback获取ip的配置
 * @Author karyzeng
 * @since 2020.12.16
 **/
@Slf4j
public class LogIpConfig extends ClassicConverter {

    private static String webIP;

    static {
        try {
            webIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("获取日志Ip异常", e);
            webIP = null;
        }
    }


    @Override
    public String convert(ILoggingEvent event) {
        return webIP;
    }
}
