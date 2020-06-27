package com.isscollege.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.users.dao.UserDao;
import com.isscollege.users.entity.Users;
import com.isscollege.users.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Users login(Users user) {
		user = userDao.login(user);
		return user;

	}

}
