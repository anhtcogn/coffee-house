package com.coffeehouse.service.impl;

import com.coffeehouse.entity.CategoryEntity;
import com.coffeehouse.entity.VoucherEntity;
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
        return categoryRepository.getCategoryEntityById(id);
    }

    @Override
    public CategoryEntity create(String name) {
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity update(String name, Long id) {
        CategoryEntity category = categoryRepository.getById(id);
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
