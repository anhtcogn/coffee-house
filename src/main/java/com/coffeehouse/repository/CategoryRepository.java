package com.coffeehouse.repository;

import com.coffeehouse.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity getById(Long id);
    List<CategoryEntity> findAll();
}
