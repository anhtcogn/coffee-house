package com.coffeehouse.repository;

import com.coffeehouse.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    VoucherEntity getById(Long id);

    List<VoucherEntity> findAll();

    @Query(value = "select * from voucher v where v.user_id = :userId and v.end_date >= current_date and v.is_used = false", nativeQuery = true)
    List<VoucherEntity> findAllByUserId(@Param("userId") Long userId);
}
