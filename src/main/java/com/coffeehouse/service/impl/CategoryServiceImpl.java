package com.coffeehouse.service.impl;

import com.coffeehouse.entity.CategoryEntity;
import com.coffeehouse.repository.CategoryRepository;
import com.coffeehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategory(Long id) {
        return categoryRepository.getById(id);
    }
}
