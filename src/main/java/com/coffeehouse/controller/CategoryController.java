package com.coffeehouse.controller;

import com.coffeehouse.entity.AddressEntity;
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

    @GetMapping("/get/{id}")
    public CategoryEntity getCategory(@PathVariable("id") Long categoryId) {
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

    @PatchMapping("/update/{id}")
    public CategoryEntity update(
            @RequestParam String name,
            @PathVariable("id") Long id
    ) {
        return categoryService.update(name, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }

}
