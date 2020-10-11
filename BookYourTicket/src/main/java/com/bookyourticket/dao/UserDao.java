package com.bookyourticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookyourticket.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
