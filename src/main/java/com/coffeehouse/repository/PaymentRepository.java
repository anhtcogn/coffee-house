package com.coffeehouse.repository;

import com.coffeehouse.entity.PaymentEntity;
import com.coffeehouse.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    PaymentEntity getById(Long id);
}
