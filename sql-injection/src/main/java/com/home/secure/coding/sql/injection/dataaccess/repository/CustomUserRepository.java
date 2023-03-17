package com.home.secure.coding.sql.injection.dataaccess.repository;

import com.home.secure.coding.web.login.dataaccess.entity.User;

import java.util.Optional;

public interface CustomUserRepository {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUserId(String userId);

}
