package com.restu.labs.service;

import java.util.List;

import com.restu.labs.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User findUserById(long id);
	public void saveUser(User user);
	public void deleteUser(User user);
	public List<User> findAllUser();
}
