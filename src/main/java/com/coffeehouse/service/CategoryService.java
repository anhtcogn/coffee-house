package com.coffeehouse.service;

import com.coffeehouse.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getListCategory();
    CategoryEntity getCategory(Long id);
    CategoryEntity create(String name);
    CategoryEntity update(String name, Long id);
    void delete(Long id);
}
