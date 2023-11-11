package com.coffeehouse.service.impl;

import com.coffeehouse.entity.OrderEntity;
import com.coffeehouse.repository.OrderRepository;
import com.coffeehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity getOrder(Long id) {
        return null;
    }

    @Override
    public List<OrderEntity> getListOrderOfUser(Long userId) {
        return null;
    }

    @Override
    public OrderEntity create(OrderEntity orderEntity, Long userId) {
        OrderEntity item = new OrderEntity();
        item.setTotalPrice(orderEntity.getTotalPrice());
        item.setOrderTime(orderEntity.getOrderTime());
        item.setPaymentMethod(orderEntity.getPaymentMethod());
        item.setReceiverName(orderEntity.getReceiverName());
        item.setReceiverPhone(orderEntity.getReceiverPhone());
        item.setReceiverAddress(orderEntity.getReceiverAddress());
        item.setStatus(orderEntity.getStatus());
        item.setRating(orderEntity.getRating());
        item.setUserId(userId);
        item.setVoucherId(userId);

        return orderRepository.save(item);
    }
}
