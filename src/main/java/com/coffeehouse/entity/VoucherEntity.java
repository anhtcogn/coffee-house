package com.coffeehouse.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    private LocalDate startDate;
    private Date endDate;

    @Transient
    private Long expireDayLeft;

    public Long getExpireDayLeft() {
    }
}
