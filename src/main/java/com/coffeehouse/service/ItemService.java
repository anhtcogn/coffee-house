package com.coffeehouse.service;

import com.coffeehouse.entity.ItemEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    List<ItemEntity> getAllItem();
    List<ItemEntity> getItemByCategory(Long categoryId);
    List<ItemEntity> getItemSuggestion(String name);
    ItemEntity getItemById(Long id);
    ItemEntity create(ItemEntity itemEntity, MultipartFile image);
    ItemEntity update(ItemEntity itemEntity, MultipartFile image);
    void delete(Long id);
}
