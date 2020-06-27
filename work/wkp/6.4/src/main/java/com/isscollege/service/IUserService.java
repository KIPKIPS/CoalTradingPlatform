package com.isscollege.service;

import java.util.List;

import com.isscollege.entity.Users;

public interface IUserService {

	int insert(Users user);

	Users login(Users user);

	List<Users> getAllUsers();

	int removeUserById(int userid);

	int updateUser_pass(Users user);

	Users getUserById(Users user);
}
