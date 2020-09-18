package com.zzp.nacos.order.service.customer;

import com.zzp.nacos.order.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description order服务消费者
 * @Author karyzeng
 * @since 2020.09.18
 **/
@FeignClient("nacos-order")
public interface OrderCustomer {

    @RequestMapping(value = "/provider/order/get", method = RequestMethod.GET)
    Order getById(@RequestParam(value = "id", required = true) Integer id);

}
