package com.coffeehouse.entity;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    private LocalDateTime orderTime;
    private String paymentMethod;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String status;
    private int rating;
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