package com.coffeehouse.service;

import com.coffeehouse.entity.VoucherEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VoucherService {
    VoucherEntity getVoucher(Long id);
    List<VoucherEntity> getAllVoucherActive();
    List<VoucherEntity> getVoucherAvailable(int billing);
    VoucherEntity createVoucher(VoucherEntity voucherEntity);
    VoucherEntity updateVoucher(VoucherEntity voucherEntity, Long id);
    VoucherEntity updateVoucherStatus(Long id, boolean active);
}
