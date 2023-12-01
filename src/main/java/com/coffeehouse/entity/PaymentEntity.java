package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    private Long id;
    private double amount;
    private String token;
    @Column(name = "payment_mode")
    private String paymentMode = "paypal";
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    private String currency = "USD";
    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "order_id")
    private Long orderId;
}
