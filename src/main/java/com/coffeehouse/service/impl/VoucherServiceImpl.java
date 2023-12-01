package com.coffeehouse.service.impl;

import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.repository.VoucherRepository;
import com.coffeehouse.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public VoucherEntity getVoucher(Long id) {
        return voucherRepository.findVoucherEntityById(id);
    }

    @Override
    public List<VoucherEntity> getAllVoucherActive() {
        return voucherRepository.findAllVoucherActive();
    }

    @Override
    public List<VoucherEntity> getVoucherAvailable(int billing) {
        return voucherRepository.getVoucherAvailable(billing);
    }

    @Override
    public VoucherEntity createVoucher(VoucherEntity voucherEntity) {
        VoucherEntity voucher = new VoucherEntity();
        voucher.setName(voucherEntity.getName());
        voucher.setDescription(voucherEntity.getDescription());
        voucher.setDiscount(voucherEntity.getDiscount());
        voucher.setEndDate(voucherEntity.getEndDate());
        voucher.setMinBilling(voucherEntity.getMinBilling());
        voucher.setActive(voucherEntity.isActive());

        return voucherRepository.save(voucher);
    }

    @Override
    public VoucherEntity updateVoucher(VoucherEntity voucherEntity, Long id) {
        VoucherEntity voucher = voucherRepository.getById(id);
        voucher.setName(voucherEntity.getName());
        voucher.setDescription(voucherEntity.getDescription());
        voucher.setDiscount(voucherEntity.getDiscount());
        voucher.setEndDate(voucherEntity.getEndDate());
        voucher.setMinBilling(voucherEntity.getMinBilling());
        voucher.setActive(voucherEntity.isActive());
        return voucherRepository.save(voucher);
    }

    @Override
    public VoucherEntity updateVoucherStatus(Long id, boolean active) {
        VoucherEntity voucher = voucherRepository.getById(id);
        voucher.setActive(active);
        return voucherRepository.save(voucher);
    }
}
