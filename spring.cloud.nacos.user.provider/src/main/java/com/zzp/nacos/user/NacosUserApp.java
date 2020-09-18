package com.zzp.nacos.user;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 启动类
 * @Author Karyzeng
 * @since 2020.08.30
 **/
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)// 配置多个数据源需要关闭自动配置数据源
@ComponentScan(basePackages={"com.zzp"})
@MapperScan("com.zzp.**.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zzp.nacos.*.service.customer")
public class NacosUserApp {

    public static void main(String[] args) {
        SpringApplication.run(NacosUserApp.class, args);
    }

}
