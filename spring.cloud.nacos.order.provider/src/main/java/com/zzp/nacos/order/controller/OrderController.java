package com.zzp.nacos.order.controller;


import com.zzp.base.results.Result;
import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author zzp
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Result<Order> getById(
            @RequestParam(value = "id", required = true) Integer id
    ) {
        try {
            Order order = orderService.getById(id);
            return Result.ok("查询成功", order);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }

}
