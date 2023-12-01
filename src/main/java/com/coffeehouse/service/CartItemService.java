package com.coffeehouse.service;

import com.coffeehouse.entity.CartItemEntity;

import java.util.List;

public interface CartItemService {
    List<CartItemEntity> getCart(Long userId);
    CartItemEntity addCart(Long itemId, Long userId, int quantity);
    CartItemEntity updateCart(Long cartId, int quantity);
    void deleteCartItem(Long cartId);
    String deleteAllByUser(Long userId);
}
