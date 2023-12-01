package com.coffeehouse.repository;

import com.coffeehouse.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
    OrderDetail getById(Long id);
    OrderDetail findOrderDetailById(Long id);
    List<OrderDetail> getAllByUserId(Long userId);

    @Query(value = "select * from orders as od where od.month = :month and od.status = 'PAYMENT SUCCESS'", nativeQuery = true)
    List<OrderDetail> getAllByMonth(int month);
}
