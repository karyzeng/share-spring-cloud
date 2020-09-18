package com.zzp.nacos.order.service.provider;

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
 * @Description order服务提供者
 * @Author karyzeng
 * @since 2020.09.18
 **/
@RestController
@RequestMapping(value = "/provider/order")
public class OrderProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Order getById(@RequestParam(value = "id", required = true) Integer id) {
        return orderService.getById(id);
    }

}
