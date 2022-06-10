package com.abn.amro.recipe.service;

import java.util.List;

import com.abn.amro.recipe.model.Role;

public interface RoleService {
	
	Role saveRole(Role role);
	List<Role> getAllRoles();

}
