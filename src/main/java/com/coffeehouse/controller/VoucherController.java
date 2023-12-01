package com.coffeehouse.controller;

import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/get/{id}")
    public VoucherEntity getVoucher(@PathVariable("id") Long id) {
        return voucherService.getVoucher(id);
    }

    @GetMapping("/active")
    public List<VoucherEntity> getVoucherActive() {
        return voucherService.getAllVoucherActive();
    }

    @GetMapping("/available")
    public List<VoucherEntity> getVoucherAvailable(int bill) {
        return voucherService.getVoucherAvailable(bill);
    }

    @PostMapping("/create")
    public VoucherEntity create(
            @ModelAttribute VoucherEntity voucherEntity
    ) {
        return voucherService.createVoucher(voucherEntity);
    }

    @PutMapping("/update/{id}")
    public VoucherEntity update(
            @ModelAttribute VoucherEntity voucherEntity,
            @PathVariable("id") Long id
    ) {
        return voucherService.updateVoucher(voucherEntity, id);
    }

    @PatchMapping("/updateVoucherStatus/{id}")
    public VoucherEntity updateStatus(
            @PathVariable("id") Long voucherId,
            @RequestParam boolean isActive
    ) {
        return voucherService.updateVoucherStatus(voucherId, isActive);
    }
}
