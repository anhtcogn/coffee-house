package com.coffeehouse.controller;

import com.azure.core.annotation.Get;
import com.coffeehouse.entity.CartItemEntity;
import com.coffeehouse.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/getByUserId/{id}")
    public List<CartItemEntity> getByUserId(@PathVariable("id") Long userId) {
        return cartItemService.getCart(userId);
    }

    @PostMapping("/addCart")
    public CartItemEntity add(
            @RequestParam Long itemId,
            @RequestParam Long userId,
            @RequestParam int quantity) {
        return cartItemService.addCart(itemId, userId, quantity);
    }

    @PutMapping("/updateCart/{id}")
    public CartItemEntity update(
            @PathVariable("id") Long id,
            @RequestParam int quantity
    ) {
        return cartItemService.updateCart(id, quantity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartItem(
            @PathVariable("id") Long id) {
        cartItemService.deleteCartItem(id);
    }
}
