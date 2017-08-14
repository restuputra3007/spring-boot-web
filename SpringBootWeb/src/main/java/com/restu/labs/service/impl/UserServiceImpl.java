package com.restu.labs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.restu.labs.model.User;
import com.restu.labs.repository.RoleRepository;
import com.restu.labs.repository.UserRepository;
import com.restu.labs.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(User user){
		userRepository.delete(user);
	}
}
