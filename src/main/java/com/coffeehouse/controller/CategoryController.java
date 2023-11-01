package com.coffeehouse.controller;

import com.coffeehouse.entity.CategoryEntity;
import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get/{categoryId}")
    public CategoryEntity getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/all")
    public List<CategoryEntity> getListCategory() {
        return categoryService.getListCategory();
    }

    @PostMapping("/create")
    public CategoryEntity create(
            @RequestParam String name) {
        return categoryService.create(name);
    }
}
