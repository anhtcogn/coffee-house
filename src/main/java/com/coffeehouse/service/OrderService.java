package com.coffeehouse.service;

import com.coffeehouse.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    OrderDetail getOrder(Long id);
    List<OrderDetail> getListOrderOfUser(Long userId);
    OrderDetail createOrder(Long addressId, Long voucherId, Long userId);
    OrderDetail confirmOrder(Long orderId);
    OrderDetail cancelOrderByUser(Long orderId);
    OrderDetail cancelOrderByAd(Long orderId);
    OrderDetail rating(Long orderId, int rating);
}
