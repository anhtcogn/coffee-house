package com.coffeehouse.controller;

import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/get/{voucherId}")
    public VoucherEntity getVoucher(@PathVariable Long voucherId) {
        return voucherService.getVoucher(voucherId);
    }

    @GetMapping("/all/{userId}")
    public List<VoucherEntity> getUserVoucher(@PathVariable Long userId) {
        return voucherService.getUserVoucher(userId);
    }

    @PostMapping("/create")
    public VoucherEntity create(
            @ModelAttribute VoucherEntity voucherEntity,
            @RequestParam(required = false) MultipartFile image,
            @RequestParam Long userId) {
        return voucherService.createVoucher(voucherEntity, image, userId);
    }

    @PutMapping("/update")
    public VoucherEntity update(
            @ModelAttribute VoucherEntity voucherEntity,
            @RequestParam(required = false) MultipartFile image) {
        return voucherService.updateVoucher(voucherEntity, image);
    }

    @PatchMapping("/updateVoucherStatus/{voucherId}")
    public VoucherEntity updateStatus(
            @PathVariable Long voucherId,
            @RequestParam boolean isUsed
    ) {
        return voucherService.updateVoucherStatus(voucherId, isUsed);
    }
}
