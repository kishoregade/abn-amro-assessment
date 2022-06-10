package com.abn.amro.recipe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.repository.RoleRepository;
import com.abn.amro.recipe.service.RoleService;
/**
 * This class is for Create and List the Roles
 * @author gpvkki
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	/**
     * Method to save the Role
     * @param role 
     * @return Role object.
     */
	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	/**
     * Method to get All Available Roles.
     * 
     * @return List of roles .
     */
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
