package com.zzp.nacos.order.service.open.impl;

import com.zzp.base.exceptions.FeignApiException;
import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.service.IOrderService;
import com.zzp.nacos.order.service.open.IOpenOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description order open接口实现类
 * @Author Karyzeng
 * @since 2020.09.18
 **/
@RestController
public class OpenOrderServiceImpl implements IOpenOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOrderService orderService;

    @Override
    public Order getById(@RequestParam(value = "id", required = true) Integer id) {
        return orderService.getById(id);
    }

    @Override
    public List<Order> listOrders(String orderNo) {
        return orderService.listOrders(orderNo);
    }

    @Override
    public String getServiceName() {
//        throw new FeignApiException("服务名不能为空111");
        logger.info("调用了serviceName服务");
        return "nacos-order-1";
    }
}
