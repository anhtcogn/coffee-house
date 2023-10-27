package com.coffeehouse.service;

import com.coffeehouse.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    List<ItemEntity> getAllItem();
    List<ItemEntity> getItemByCategory(Long categoryId);
    ItemEntity getItemById(Long id);
}
