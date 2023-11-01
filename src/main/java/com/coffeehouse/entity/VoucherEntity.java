package com.coffeehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "voucher")
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String content;
    private String description;
    private int quantity;
    @Column(name = "end_date")
    private int endDate;
    private int discount;
    @Column(name = "is_used")
    private boolean isUsed;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "voucher_type")
    @Enumerated(EnumType.STRING)
    private VoucherType voucherType;
    
    @Transient
    private int expireDayLeft = getExpireDayLeft(endDate);

    public int getExpireDayLeft(int endDate) {
        LocalDate currentDate = LocalDate.now();
        return endDate - currentDate.getDayOfMonth();
    }

    enum VoucherType {
        SHIPPING, BILL
    }
}
