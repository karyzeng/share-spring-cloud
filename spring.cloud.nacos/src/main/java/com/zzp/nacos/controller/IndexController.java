package com.zzp.nacos.controller;

import com.zzp.nacos.log.entity.SpringCloudNacosLogEntity;
import com.zzp.nacos.log.repository.SpringCloudNacosLogRepository;
import com.zzp.nacos.service.ICommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description nacos测试controller
 * @Author karyzeng
 * @since 2020.09.11
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ICommonService commonService;

    @Autowired
    private SpringCloudNacosLogRepository springCloudNacosLogRepository;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "testAsync", method = RequestMethod.GET)
    public String testAsync() {
        long start = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        commonService.asyncTest();
        logger.info(name + "返回了hello async");
        long end = System.currentTimeMillis();

        SpringCloudNacosLogEntity entity = new SpringCloudNacosLogEntity();
        entity.setHost("127.0.0.1");
        entity.setPort("8080");
        entity.setMessage("测试直接操作ES API");
        entity.setCreateTime(new Date());

        SpringCloudNacosLogEntity entity1 = springCloudNacosLogRepository.save(entity);
        return "hello async," + (end - start);
    }

}
