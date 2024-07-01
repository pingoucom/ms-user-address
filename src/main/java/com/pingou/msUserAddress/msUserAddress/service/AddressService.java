package com.pingou.msUserAddress.msUserAddress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingou.msUserAddress.msUserAddress.model.Address;
import com.pingou.msUserAddress.msUserAddress.model.AddressDto;
import com.pingou.msUserAddress.msUserAddress.repository.AddressRepository;
import com.pingou.msUserAddress.msUserAddress.util.Utill;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    Utill utill;

   
    public List<AddressDto> getAllAddress(){
        List<Address> addressList=addressRepository.findAll();
        List<AddressDto> addressDtoList=new ArrayList<>();
        addressList.stream().forEach(address -> addressDtoList.add(utill.addressToAddressDto(address)));
        return  addressDtoList;
    }

    public List<AddressDto> findAddressByUserId(String userId) {
        List<AddressDto> addresses = getAllAddress();
        List<AddressDto> addressesuser = new ArrayList<>();
        addresses.stream().forEach(address -> {
            if(address.getUserId().equals(userId)){
                addressesuser.add(address);
            }
        });

        return addressesuser;
    }
    

    public AddressDto findDefaultAddress(String userId) {
        List<AddressDto> addresses = findAddressByUserId(userId);
        Optional<AddressDto> defaultAddress = addresses.stream()
                .filter(AddressDto::isDefault)
                .findFirst();

        return defaultAddress.orElse(null);
    }

    public Address saveAddress(AddressDto addressDto){
        addressRepository.save(utill.addressDtoToAddress(addressDto));
        Address address = utill.addressDtoToAddress(addressDto);
        return  address;
    }

    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = utill.addressDtoToAddress(addressDto);
        address = addressRepository.save(address);
        return utill.addressToAddressDto(address);
    }

    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }
}
