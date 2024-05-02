package com.pingou.msuseradress.service;

import com.pingou.msuseradress.entity.Address;
import com.pingou.msuseradress.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> findAddressesByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }
//
//    public Address saveAddress(String userId, Address address) {
//        address.setUserId(userId);
//        return addressRepository.save(address);
//    }

//    public void updateAddress(String userId, String id, Address address) {
//        Address existingAddress = addressRepository.findByUserIdAndId(userId, id);
//        if (existingAddress != null) {
//            address.setId(id);
//            address.setUserId(userId);
//            addressRepository.save(address);
//        }
//    }

//    public void deleteAddress(String userId, String id) {
//        Address existingAddress = addressRepository.findByUserIdAndId(userId, id);
//        if (existingAddress != null) {
//            addressRepository.delete(existingAddress);
//        }
//    }

    //Apenas teste daqui para baixo

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }
    public void savingAddress(Address address) {
        addressRepository.save(address);
    }

    public void deletingAddress(Long id) {
        addressRepository.deleteById(id);
    }
    public void updatingAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            address.setId(id);
            addressRepository.save(address);
        }
    }

}
