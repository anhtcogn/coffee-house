package com.coffeehouse.service;

import com.coffeehouse.entity.VoucherEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VoucherService {
    VoucherEntity getVoucher(Long id);
    List<VoucherEntity> getUserVoucher(Long userId);
    VoucherEntity createVoucher(VoucherEntity voucherEntity, MultipartFile image, Long userId);
    VoucherEntity updateVoucher(VoucherEntity voucherEntity, MultipartFile image);
    VoucherEntity updateVoucherStatus(Long id, boolean isUsed);
}
