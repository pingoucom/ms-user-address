package com.pingou.msuseradress.controller;

import com.pingou.msuseradress.entity.Address;
import com.pingou.msuseradress.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/users/{userId}/addresses")
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //para teste abaixo
    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping
    public void savingAddress(@RequestBody Address address) {
        addressService.savingAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deletingAddress(@PathVariable Long id) {
        addressService.deletingAddress(id);
    }

    @PutMapping("/{id}")
    public void updatingAddress(@PathVariable Long id, @RequestBody Address address) {
        addressService.updatingAddress(id, address);
    }

    @GetMapping("/{userId}")
    public List<Address> getAddresses(@PathVariable String userId) {
        return addressService.findAddressesByUserId(userId);
    }

    //para teste acima

//    @GetMapping
//    public List<Address> getAddresses(@PathVariable String userId) {
//        return addressService.findAddressesByUserId(userId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Address createAddress(@PathVariable String userId, @RequestBody Address address) {
//        return addressService.saveAddress(userId, address);
//    }
//
//    @PutMapping("/{id}")
//    public void updateAddress(@PathVariable String userId, @PathVariable String id, @RequestBody Address address) {
//        addressService.updateAddress(userId, id, address);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAddress(@PathVariable String userId, @PathVariable String id) {
//        addressService.deleteAddress(userId, id);
//    }


}

