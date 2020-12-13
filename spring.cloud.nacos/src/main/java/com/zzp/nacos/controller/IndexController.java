package com.zzp.nacos.controller;

import com.zzp.nacos.service.ICommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello async," + (end - start);
    }

}
