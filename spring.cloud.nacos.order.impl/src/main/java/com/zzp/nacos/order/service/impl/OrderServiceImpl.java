package com.zzp.nacos.order.service.impl;

import com.zzp.nacos.order.entity.Order;
import com.zzp.nacos.order.mapper.OrderMapper;
import com.zzp.nacos.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
