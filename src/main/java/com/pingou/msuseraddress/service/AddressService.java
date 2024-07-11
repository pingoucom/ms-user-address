package com.pingou.msuseraddress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pingou.msuseraddress.model.Address;
import com.pingou.msuseraddress.model.AddressDto;
import com.pingou.msuseraddress.util.Utill;
import org.springframework.stereotype.Service;

import com.pingou.msuseraddress.repository.AddressRepository;

@Service
public class AddressService {
    AddressRepository addressRepository;

    Utill utill;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.utill = new Utill();
    }
   
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
        return addressRepository.save(utill.addressDtoToAddress(addressDto));
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
