package com.coffeehouse.repository;

import com.coffeehouse.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    AddressEntity getAddressEntityById(Long id);
    List<AddressEntity> getAllByUserId(Long userId);
}
