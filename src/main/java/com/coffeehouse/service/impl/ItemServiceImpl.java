package com.coffeehouse.service.impl;

import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.repository.ItemRepository;
import com.coffeehouse.service.ImageService;
import com.coffeehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.coffeehouse.constant.constants.AZURE_CONTAINER;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ImageService imageService;

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
        item.setOriginPrice(itemEntity.getOriginPrice());
        item.setCategoryId(itemEntity.getCategoryId());

        if (image != null && !image.isEmpty()) {
            String path = imageService.uploadImage(image, AZURE_CONTAINER);
            item.setImage(path);
        } else item.setImage(null);

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

        if (image != null && !image.isEmpty()) {
            String existImage = item.getImage();
            imageService.deleteImage(existImage, AZURE_CONTAINER);
            System.out.println("delete success");
            item.setImage(imageService.uploadImage(image, AZURE_CONTAINER));
        } else {
            item.setImage(item.getImage());
        }

        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        imageService.deleteImage(itemRepository.getById(id).getImage(), AZURE_CONTAINER);
        System.out.println("delete success");
        itemRepository.deleteById(id);
    }
}
