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
        return addressRepository.getAddressEntityById(id);
    }

    @Override
    public AddressEntity create(String address,
                                String name,
                                String phone,
                                Long userId) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setReceiveAddress(address);
        addressEntity.setReceiveName(name);
        addressEntity.setReceivePhone(phone);
        addressEntity.setUserId(userId);
        return addressRepository.save(addressEntity);
    }

    @Override
    public AddressEntity update(String address,
                                String name,
                                String phone,
                                Long addressId) {
        AddressEntity addressEntity = addressRepository.getAddressEntityById(addressId);
        addressEntity.setReceiveAddress(address);
        addressEntity.setReceiveName(name);
        addressEntity.setReceivePhone(phone);
        return addressRepository.save(addressEntity);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
