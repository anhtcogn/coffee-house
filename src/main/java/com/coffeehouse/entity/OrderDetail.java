package com.coffeehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double total;
    @Column(name = "order_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime = LocalDateTime.now();
    private int month = LocalDateTime.now().getMonthValue();
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "address_id")
    private Long addressId;
    private String status;
    private int rating;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "voucher_id")
    private Long voucherId;

}
//    /* get (đang thực hiện, đã hoàn tất, đã hủy), add, huy don hang, đánh giá đơn hàng
//        - ma don hang
//        - user(ten, so dien thoai)
//        - thoi gian
//        - cac san pham
//        - dia chi
//        - gia tien
//        - phuong thuc thanh toan (tien mat, paypal)
//        - voucher
//        - trang thai don hang (dang thuc hien, da hoan tat, da huy) // 1p đầu đặt hang có quyền hủy đơn hàng,
//                                                                 sau 1p tự động chuyển trạng thái sang đang thực hiện
//        - danh gia don hang (rating bar) = null
//    */