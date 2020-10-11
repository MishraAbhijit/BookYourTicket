package com.bookyourticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookyourticket.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
