package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;

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

    @Column(name = "category_id")
    private Long categoryId;
}


