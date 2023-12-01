package com.coffeehouse.controller;

import com.coffeehouse.entity.AddressEntity;
import com.coffeehouse.payload.Response;
import com.coffeehouse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/get/{id}")
    public AddressEntity get(@PathVariable("id") Long id) {
        return addressService.getAddress(id);
    }

    @GetMapping("/getByUser/{userId}")
    public List<AddressEntity> getAddressOfUser(@PathVariable Long userId) {
        return addressService.getAddressOfUser(userId);
    }

    @PostMapping("/create")
    public AddressEntity create(
            @RequestParam String address,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam Long userId
    ) {
        return addressService.create(address, name, phone, userId);
    }

    @PatchMapping("/update/{id}")
    public AddressEntity update(
            @RequestParam String address,
            @RequestParam String name,
            @RequestParam String phone,
            @PathVariable("id") Long id
    ) {
        return addressService.update(address, name, phone, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.delete(id);
    }
}
