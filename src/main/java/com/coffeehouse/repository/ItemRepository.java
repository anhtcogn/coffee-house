package com.coffeehouse.repository;
import com.coffeehouse.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    ItemEntity getById(Long id);
    List<ItemEntity> getAllByCategoryId(Long categoryId);
}
