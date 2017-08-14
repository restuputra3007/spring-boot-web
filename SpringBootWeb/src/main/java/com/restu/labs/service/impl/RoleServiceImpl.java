package com.restu.labs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restu.labs.model.Role;
import com.restu.labs.repository.RoleRepository;
import com.restu.labs.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role findRoleByRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByRole(role);
	}

	@Override
	public List<Role> findRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
