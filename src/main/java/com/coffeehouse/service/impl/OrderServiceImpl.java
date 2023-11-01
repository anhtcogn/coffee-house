package com.coffeehouse.service.impl;

import com.coffeehouse.entity.OrderEntity;
import com.coffeehouse.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderEntity getOrder(Long id) {
        return null;
    }

    @Override
    public List<OrderEntity> getListOrderOfUser(Long userId) {
        return null;
    }
}
