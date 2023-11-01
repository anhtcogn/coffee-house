package com.coffeehouse.service.impl;

import com.coffeehouse.entity.VoucherEntity;
import com.coffeehouse.repository.VoucherRepository;
import com.coffeehouse.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public VoucherEntity getVoucher(Long id) {
        return voucherRepository.getById(id);
    }

    @Override
    public List<VoucherEntity> getUserVoucher(Long userId) {
        return voucherRepository.findAllByUserId(userId);
    }

    @Override
    public VoucherEntity createVoucher(VoucherEntity voucherEntity, MultipartFile image, Long userId) {
        VoucherEntity voucher = new VoucherEntity();
        voucher.setContent(voucherEntity.getContent());
        voucher.setDescription(voucherEntity.getDescription());
        voucher.setDiscount(voucherEntity.getDiscount());
        voucher.setEndDate(voucherEntity.getEndDate());
        voucher.setImage(String.valueOf(image));
        voucher.setUsed(false);
        voucher.setQuantity(voucherEntity.getQuantity());
        voucher.setUserId(userId);
        voucher.setVoucherType(voucherEntity.getVoucherType());
        return voucherRepository.save(voucher);
    }

    @Override
    public VoucherEntity updateVoucher(VoucherEntity voucherEntity, MultipartFile image) {
        VoucherEntity voucher = voucherRepository.getById(voucherEntity.getId());
        voucher.setContent(voucherEntity.getContent());
        voucher.setDescription(voucherEntity.getDescription());
        voucher.setDiscount(voucherEntity.getDiscount());
        voucher.setEndDate(voucherEntity.getEndDate());
        voucher.setImage(String.valueOf(image));
        voucher.setUsed(voucherEntity.isUsed());
        voucher.setQuantity(voucherEntity.getQuantity());
        voucher.setUserId(voucherEntity.getUserId());
        voucher.setVoucherType(voucherEntity.getVoucherType());
        return voucherRepository.save(voucher);
    }

    @Override
    public VoucherEntity updateVoucherStatus(Long id, boolean isUsed) {
        VoucherEntity voucher = voucherRepository.getById(id);
        voucher.setUsed(isUsed);
        return voucherRepository.save(voucher);
    }
}
