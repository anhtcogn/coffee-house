package com.coffeehouse.repository;

import com.coffeehouse.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    CartItemEntity getCartItemEntityById(Long id);
    List<CartItemEntity> getAllByUserId(Long id);
    void deleteAllByUserId(Long userId);
}
