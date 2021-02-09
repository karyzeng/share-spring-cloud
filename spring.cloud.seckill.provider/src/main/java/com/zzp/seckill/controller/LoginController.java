package com.zzp.seckill.controller;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.base.results.Result;
import com.zzp.seckill.service.ISysUserService;
import com.zzp.seckill.util.CookieUtils;
import com.zzp.seckill.vo.LoginUserVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description LoginController
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Validated @RequestBody LoginUserVo loginUserVo) {
        try {
            String token = sysUserService.login(loginUserVo);
            if (StringUtils.isNotBlank(token)) {
                CookieUtils.addCookie(response, token);
                return Result.ok("登录成功");
            }
            return Result.failed("登录失败，无法获取token");
        } catch (ApiException e) {
            e.printStackTrace();
            return Result.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("登录失败");
        }

    }

}
