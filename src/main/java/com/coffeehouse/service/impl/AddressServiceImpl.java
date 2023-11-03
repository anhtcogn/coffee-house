package com.coffeehouse.service.impl;

import com.coffeehouse.entity.AddressEntity;
import com.coffeehouse.repository.AddressRepository;
import com.coffeehouse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressEntity> getAddressOfUser(Long userid) {
        return addressRepository.getAllByUserId(userid);
    }

    @Override
    public AddressEntity getAddress(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public AddressEntity create(AddressEntity addressEntity) {
        AddressEntity address = new AddressEntity();
        address.setAddress(addressEntity.getAddress());
        address.setId(addressEntity.getId());
        return addressRepository.save(address);
    }
}
