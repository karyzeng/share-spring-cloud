package com.zzp.seckill.controller;

import com.zzp.seckill.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description IndexController
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        String user = SecurityUtils.getUser();
        return "hello " + user;
    }

}
