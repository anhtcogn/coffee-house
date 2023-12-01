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

    @Column(name = "receive_address")
    private String receiveAddress;
    @Column(name = "receive_name")
    private String receiveName;
    @Column(name = "receive_phone")
    private String receivePhone;

    @Column(name = "user_id")
    private Long userId;
}
