package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;
    private int quantity;
    private double cost;
    @Column(name = "user_id")
    private Long userId;
}
