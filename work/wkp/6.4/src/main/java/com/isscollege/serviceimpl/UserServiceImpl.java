package com.isscollege.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isscollege.dao.UsersDao;
import com.isscollege.entity.Users;
import com.isscollege.service.IUserService;

@Service // 标记当前类是service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UsersDao userDao;

	@Override
	public Users login(Users user) {
		user = userDao.login(user);
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public int insert(Users user) {
		return userDao.insert(user);
	}

	@Override
	public int removeUserById(int userid) {
		return userDao.removeUserById(userid);
	}

	@Override
	public int updateUser_pass(Users user) {
		return userDao.updateUser_pass(user);
	}

	@Override
	public Users getUserById(Users user) {
		return userDao.getUserById(user);
	}

}
