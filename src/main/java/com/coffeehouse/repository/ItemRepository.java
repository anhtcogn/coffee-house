package com.coffeehouse.repository;
import com.coffeehouse.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    ItemEntity findItemEntityById(Long id);
    List<ItemEntity> getAllByCategoryId(Long categoryId);
    ItemEntity findByName(String name);

    @Query(value = "select * from item i where i.name like '%:name%'", nativeQuery = true)
    List<ItemEntity> getSuggestItem(@Param("name") String name);
}
