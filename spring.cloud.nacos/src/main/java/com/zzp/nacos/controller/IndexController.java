package com.zzp.nacos.controller;

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

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }

}
