package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @Column(name = "id")
    private Long id;
    private double amount;
    private String token;
    private String paymentMode = "paypal";
    private LocalDateTime paymentDate;
    private String currency = "USD";
    private String paymentStatus;

    @Column(name = "order_id")
    private Long orderId;
}
