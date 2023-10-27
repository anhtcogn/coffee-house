package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @Column(name = "user_id")
    private Long userId;
}
