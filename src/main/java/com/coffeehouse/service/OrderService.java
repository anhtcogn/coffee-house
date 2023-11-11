package com.coffeehouse.service;

import com.coffeehouse.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity getOrder(Long id);
    List<OrderEntity> getListOrderOfUser(Long userId);
    OrderEntity createOrder(OrderEntity orderEntity, Long userId);
    OrderEntity confirmOrder(Long orderId);
    OrderEntity cancelOrderByUser(Long orderId);
    OrderEntity cancelOrderByAd(Long orderId);
    OrderEntity rating(Long orderId, int rating);
}
