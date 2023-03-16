package com.home.secure.coding.web.login.service;

import com.home.secure.coding.web.login.dataaccess.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> getUserInfo(String userId);
}
