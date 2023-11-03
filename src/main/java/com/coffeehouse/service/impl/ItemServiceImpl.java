package com.coffeehouse.service.impl;

import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.repository.ItemRepository;
import com.coffeehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        return itemRepository.getAllByCategoryId(categoryId);
    }

    @Override
    public List<ItemEntity> getItemSuggestion(String name) {
        return itemRepository.getSuggestItem(name);
    }

    @Override
    public ItemEntity getItemById(Long id) {
        return itemRepository.getById(id);
    }

    @Override
    public ItemEntity create(ItemEntity itemEntity, MultipartFile image) {
        ItemEntity item = new ItemEntity();
        item.setName(itemEntity.getName());
        item.setDescription(itemEntity.getDescription());
        item.setImage(String.valueOf(image));
        item.setOriginPrice(itemEntity.getOriginPrice());
        item.setCategoryId(itemEntity.getCategoryId());
        return itemRepository.save(item);
    }

    @Override
    public ItemEntity update(ItemEntity itemEntity, MultipartFile image) {
        ItemEntity item = itemRepository.getById(itemEntity.getId());
        item.setName(itemEntity.getName());
        item.setDescription(itemEntity.getDescription());
        item.setImage(String.valueOf(image));
        item.setOriginPrice(itemEntity.getOriginPrice());
        item.setCategoryId(itemEntity.getCategoryId());
        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
