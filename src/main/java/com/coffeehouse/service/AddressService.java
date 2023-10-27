package com.coffeehouse.service;

import com.coffeehouse.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    List<AddressEntity> getAddressOfUser(Long userid);
    AddressEntity getAddress(Long id);
}
