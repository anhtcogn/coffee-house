package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private Long itemId;
    private int quantity;
    private String size;
    private String topping;

    @Column(name = "order_id")
    private Long orderId;
}
