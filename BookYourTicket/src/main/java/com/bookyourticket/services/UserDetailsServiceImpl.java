package com.bookyourticket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookyourticket.dao.UserDao;
import com.bookyourticket.dto.UIProperties;
import com.bookyourticket.entity.User;

@Service
public class UserDetailsServiceImpl extends UIProperties implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not found for given email: " + username);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getRoles());
	}

}
