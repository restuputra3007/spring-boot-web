package com.restu.labs.service;

import java.util.List;

import com.restu.labs.model.Role;

public interface RoleService {
	public Role findRoleByRole(String role);
	public List<Role> findRoles();
}
