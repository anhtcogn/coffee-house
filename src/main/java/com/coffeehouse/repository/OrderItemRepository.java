package com.coffeehouse.repository;

import com.coffeehouse.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getOrderItemByOrderId(Long orderId);
}
