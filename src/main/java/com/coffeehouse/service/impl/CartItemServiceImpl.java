package com.coffeehouse.service.impl;

import com.coffeehouse.entity.CartItemEntity;
import com.coffeehouse.entity.ItemEntity;
import com.coffeehouse.entity.OrderDetail;
import com.coffeehouse.repository.CartItemRepository;
import com.coffeehouse.repository.ItemRepository;
import com.coffeehouse.repository.OrderRepository;
import com.coffeehouse.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<CartItemEntity> getCart(Long userId) {
        return cartItemRepository.getAllByUserId(userId);
    }


    @Override
    public CartItemEntity addCart(Long itemId, Long userId, int quantity) {
        ItemEntity item = itemRepository.getById(userId);
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setUserId(userId);
        cartItem.setItemId(itemId);
        cartItem.setItemName(item.getName());
        cartItem.setQuantity(quantity);
        cartItem.setCost(quantity * item.getPrice());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItemEntity updateCart(Long id, int quantity) {
        CartItemEntity cartItem = cartItemRepository.getCartItemEntityById(id);
        ItemEntity item = itemRepository.getById(cartItem.getItemId());
        cartItem.setQuantity(quantity);
        cartItem.setCost(quantity * item.getPrice());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long cartId) {
        cartItemRepository.deleteById(cartId);
    }

    @Override
    @Transactional
    public String deleteAllByUser(Long userId) {
        cartItemRepository.deleteAllByUserId(userId);
        return "delete success";
    }

}
