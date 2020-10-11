package com.bookyourticket.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookyourticket.dao.UserDao;
import com.bookyourticket.dto.UIProperties;
import com.bookyourticket.entity.User;

@Service
public class UserServices extends UIProperties{

	@Autowired
	UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public boolean saveUser(HttpSession session,User user) {
		System.out.println("==== Saving User ====");
		user.setPassword(encoder.encode(user.getPassword()));
		User save = userDao.save(user);
		System.out.println("=== Saved User ==="+save);
		return true;
	}
}
