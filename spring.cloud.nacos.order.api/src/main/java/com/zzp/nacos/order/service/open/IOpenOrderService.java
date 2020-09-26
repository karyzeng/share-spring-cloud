package com.zzp.nacos.order.service.open;

import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.service.open.fallback.NotBreakerConfiguration;
import com.zzp.nacos.order.service.open.fallback.OpenOrderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description order open接口
 * @Author karyzeng
 * @since 2020.09.18
 **/
@FeignClient(value = "nacos-order", fallback = OpenOrderFallbackService.class, configuration = NotBreakerConfiguration.class)
public interface IOpenOrderService {

    @RequestMapping(value = "/open/order/get", method = RequestMethod.GET)
    Order getById(@RequestParam(value = "id", required = true) Integer id);

    @RequestMapping(value = "/open/order/listOrders", method = RequestMethod.GET)
    List<Order> listOrders(@RequestParam(value = "orderNo", required = true) String orderNo);

    @RequestMapping(value = "/open/order/serviceName/get", method = RequestMethod.GET)
    String getServiceName();

}
