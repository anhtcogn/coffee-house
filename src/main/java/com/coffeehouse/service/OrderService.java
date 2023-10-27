package com.coffeehouse.service;

import com.coffeehouse.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity getOrder(Long id);
    List<OrderEntity> getListOrderOfUser(Long userId);
}
