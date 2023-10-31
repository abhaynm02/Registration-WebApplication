package com.datatBasedemo.registerationFrom.Service;

import com.datatBasedemo.registerationFrom.Model.UserRegister;

import java.util.List;

public interface UserServicein {
    void registerUser(UserRegister user);
    void  deleteAccound(Long Id);
    List<UserRegister> getUser(Long id);
    List<UserRegister>getAllUsers();
}
