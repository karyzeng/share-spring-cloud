package com.zzp.nacos.order.service.open.fallback;

import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.service.open.IOpenOrderService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description order open fallback service
 * @Author Garyzeng
 * @since 2020.09.26
 **/
@Component
public class OpenOrderFallbackService implements IOpenOrderService {

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public List<Order> listOrders(String orderNo) {
        return null;
    }

    @Override
    public String getServiceName() {
        return "调用失败，服务被降级";
    }
}
