package com.zzp.nacos.order.service;

import com.zzp.nacos.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author zzp
 * @since 2020-09-17
 */
public interface IOrderService extends IService<Order> {

    List<Order> listOrders(String orderNo);

}
