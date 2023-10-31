package com.datatBasedemo.registerationFrom.Service;

import com.datatBasedemo.registerationFrom.Model.UserRegister;
import com.datatBasedemo.registerationFrom.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserSrvice implements UserServicein{
    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(UserRegister user) {
        userRepository.save(user);
    }

    @Override
    public void deleteAccound(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public List<UserRegister> getUser(Long Id) {
        return userRepository.findAllById(Collections.singleton(Id));
    }

    @Override
    public List<UserRegister> getAllUsers() {
        return userRepository.findAll();
    }


}
