package com.pingou.msuseraddress.repository;

import com.pingou.msuseraddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // Certifique-se de importar a lista correta


@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findByUserId(String userId);
}
