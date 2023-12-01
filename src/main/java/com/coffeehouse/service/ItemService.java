package com.coffeehouse.service;

import com.coffeehouse.entity.ItemEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    List<ItemEntity> getAllItem();

    List<ItemEntity> getItemByCategory(Long categoryId);

    List<ItemEntity> getItemSuggestion(String name);

    ItemEntity getItemById(Long id);

    ItemEntity create(String name,
                      double price,
                      String description,
                      Long categoryId,
                      MultipartFile image);

    ItemEntity update(String name,
                      double price,
                      String description,
                      Long categoryId,
                      MultipartFile image, Long id);

    void delete(Long id);
}
