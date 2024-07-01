package com.pingou.msUserAddress.msUserAddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // Certifique-se de importar a lista correta

import com.pingou.msUserAddress.msUserAddress.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findByUserId(String userId);
}
