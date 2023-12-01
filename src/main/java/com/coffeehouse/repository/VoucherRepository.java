package com.coffeehouse.repository;

import com.coffeehouse.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    VoucherEntity findVoucherEntityById(Long id);

    @Query(value = "select * from voucher v where v.end_date >= current_date and v.active = true", nativeQuery = true)
    List<VoucherEntity> findAllVoucherActive();

    @Query(value = "select * from voucher v where v.min_billing <= :billing and v.end_date >= current_date and v.active = true", nativeQuery = true)
    List<VoucherEntity> getVoucherAvailable(@Param("billing") int billing);
}
