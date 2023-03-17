package com.home.secure.coding.sql.injection.dataaccess.repository;

import com.home.secure.coding.sql.injection.dataaccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {
}
