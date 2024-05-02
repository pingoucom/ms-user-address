package com.pingou.msuseradress.repository;

import com.pingou.msuseradress.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findByUserId(String userId);
//    Address findByUserIdAndId(String userId, Long id);
}
