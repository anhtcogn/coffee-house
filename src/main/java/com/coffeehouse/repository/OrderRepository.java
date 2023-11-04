package com.coffeehouse.repository;
import com.coffeehouse.entity.AddressEntity;
import com.coffeehouse.entity.OrderEntity;
import com.paypal.api.payments.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
    OrderEntity getById(Long id);
    List<OrderEntity> getAllByUserId(Long userId);

}
