package com.coffeehouse.controller;

import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/getById/{id}")
    public ItemEntity getById(@PathVariable("id") Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/getByCategory/{id}")
    public List<ItemEntity> getByCategoryId(@PathVariable("id") Long id) {
        return itemService.getItemByCategory(id);
    }

    @GetMapping("/getAll")
    public List<ItemEntity> getAll() {
        return itemService.getAllItem();
    }

    @GetMapping("/getItemSuggestion/{name}")
    public List<ItemEntity> getItemSuggestion(@PathVariable("name") String name) {
        return itemService.getItemSuggestion(name);
    }

    @PostMapping("/create")
    public ItemEntity create(
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String description,
            @RequestParam Long categoryId,
            @RequestParam(required = false) MultipartFile image
                             ) throws IOException {
        return itemService.create(name, price, description, categoryId, image);
    }

    @PutMapping("/update/{id}")
    public ItemEntity update(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam String description,
                             @RequestParam Long categoryId,
                             @RequestParam(required = false) MultipartFile image,
                             @PathVariable("id") Long id
    ) {
        return itemService.update(name, price, description, categoryId, image, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        itemService.delete(id);
    }
}
