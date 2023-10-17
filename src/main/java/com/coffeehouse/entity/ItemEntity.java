package com.coffeehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String itemImage;
    private String name;

    @Column(name = "price")
    private Double originPrice;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    enum ProductCategory {
        COFFEE, TEA, FRUIT_JUICE, CAKE
    }
}


