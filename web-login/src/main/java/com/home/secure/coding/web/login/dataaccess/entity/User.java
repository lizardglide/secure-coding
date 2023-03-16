package com.home.secure.coding.web.login.dataaccess.entity;

import java.math.BigInteger;

public interface User {

    BigInteger getId();
    void setId(BigInteger id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getFirstname();
    void setFirstname(String firstname);
    String getSurname();
    void setSurname(String surname);
}
