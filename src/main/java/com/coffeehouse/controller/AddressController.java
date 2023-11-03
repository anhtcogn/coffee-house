package com.coffeehouse.controller;

import com.coffeehouse.entity.AddressEntity;
import com.coffeehouse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/get")
    public AddressEntity get(@RequestParam Long id) {
        return addressService.getAddress(id);
    }

    @GetMapping("/getByUser/{userId}")
    public List<AddressEntity> getAddressOfUser(@PathVariable Long userId) {
        return addressService.getAddressOfUser(userId);
    }

    @PostMapping("/create")
    public AddressEntity create(@ModelAttribute AddressEntity addressEntity) {
        return addressService.create(addressEntity);
    }
}
