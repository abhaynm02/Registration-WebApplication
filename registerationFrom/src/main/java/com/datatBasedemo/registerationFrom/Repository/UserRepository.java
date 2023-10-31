package com.datatBasedemo.registerationFrom.Repository;

import com.datatBasedemo.registerationFrom.Model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegister,Long> {
}
