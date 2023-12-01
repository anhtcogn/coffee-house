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
        return itemRepository.findItemEntityById(id);
    }

    @Override
    public ItemEntity create(String name,
                             double price,
                             String description,
                             Long categoryId,
                             MultipartFile image) {
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setCategoryId(categoryId);

        if (image != null && !image.isEmpty()) {
            String path = imageService.uploadImage(image, AZURE_CONTAINER);
            System.out.println(path);
            item.setImage(path);
        } else item.setImage("");

        return itemRepository.save(item);
    }

    @Override
    public ItemEntity update(String name,
                             double price,
                             String description,
                             Long categoryId,
                             MultipartFile image, Long id) {
        ItemEntity item = itemRepository.getById(id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setCategoryId(categoryId);


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
