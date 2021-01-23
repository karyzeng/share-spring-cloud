package com.zzp.seckill.controller;

import com.zzp.base.results.Result;
import com.zzp.seckill.vo.LoginUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description LoginController
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(@Validated @RequestBody LoginUserVo loginUserVo) {
        return Result.ok("登录成功");
    }

}
