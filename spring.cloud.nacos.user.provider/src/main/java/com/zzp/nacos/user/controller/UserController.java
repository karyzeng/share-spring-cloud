package com.zzp.nacos.user.controller;


import com.zzp.base.results.Result;
import com.zzp.nacos.user.entity.User;
import com.zzp.nacos.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zzp
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result<User> getById(
            @RequestParam(value = "id", required = true) Integer id
    ) {
        try {
            User user = userService.getById(id);
            userService.testOrder();
            return Result.ok("查询成功", user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }

}
