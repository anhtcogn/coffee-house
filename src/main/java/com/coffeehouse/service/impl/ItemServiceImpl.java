package com.coffeehouse.service.impl;

import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.repository.ItemRepository;
import com.coffeehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemEntity> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public List<ItemEntity> getItemByCategory(Long categoryId) {
        return null;
    }

    @Override
    public ItemEntity getItemById(Long id) {
        return itemRepository.getById(id);
    }
}
