package com.coffeehouse.service;

import com.coffeehouse.entity.CartItemEntity;
import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.repository.ItemRepository;
import com.coffeehouse.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    public double calculate(Long itemId, int quantity, Long voucherId) {
        double discount = 0;
        if (voucherId != null) {
            discount = voucherRepository.getById(voucherId).getDiscount();
        }
        ItemEntity itemEntity = itemRepository.getById(itemId);
        return itemEntity.getPrice() * quantity - discount;
    }
}