package com.zzp.nacos.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.mapper.OrderMapper;
import com.zzp.nacos.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2020-09-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public List<Order> listOrders(String orderNo) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<Order>();
        queryWrapper.eq(Order::getOrderNo, orderNo);
        return this.list(queryWrapper);
    }
}
