package com.coffeehouse.service;

import com.coffeehouse.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    List<AddressEntity> getAddressOfUser(Long userid);
    AddressEntity getAddress(Long id);
    AddressEntity create(String address,
                         String name,
                         String phone,
                         Long userId);
    AddressEntity update(String address,
                         String name,
                         String phone,
                         Long addressId);
    void delete(Long id);
}
