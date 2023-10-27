package com.coffeehouse.repository;
import com.coffeehouse.entity.AddressEntity;
import com.coffeehouse.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
}
