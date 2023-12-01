package com.coffeehouse.repository;

import com.coffeehouse.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findUserEntityById(Long id);
    boolean existsByUsername(String username);

}
