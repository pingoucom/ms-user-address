package com.pingou.msUserAddress.msUserAddress.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pingou.msUserAddress.msUserAddress.model.Address;
import com.pingou.msUserAddress.msUserAddress.model.AddressDto;
import com.pingou.msUserAddress.msUserAddress.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddressesByUserId(@PathVariable String userId) {
        List<AddressDto> addresses = addressService.findAddressByUserId(userId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/default")
    public ResponseEntity<AddressDto> getDefaultAddress(@PathVariable String userId) {
        AddressDto defaultAddress = addressService.findDefaultAddress(userId);
        if (defaultAddress != null) {
            return new ResponseEntity<>(defaultAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@PathVariable String userId, @RequestBody AddressDto addressDto) {
        addressDto.setUserId(userId);
        Address savedAddress = addressService.saveAddress(addressDto);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Void> updateAddress(@PathVariable String userId, @PathVariable String addressId, @RequestBody AddressDto addressDto) {
        addressDto.setId(addressId);
        addressDto.setUserId(userId);
        addressService.updateAddress(addressDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String userId, @PathVariable String addressId) {
        List<AddressDto> addresses = addressService.findAddressByUserId(userId);
        boolean addressExists = addresses.stream().anyMatch(address -> address.getId().equals(addressId));
        if (addressExists) {
            addressService.deleteAddress(addressId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
