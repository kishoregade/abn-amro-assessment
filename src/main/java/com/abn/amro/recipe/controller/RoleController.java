package com.abn.amro.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.service.RoleService;
/**
 * 
 * 
 * RoleController Class with REST API methods.
 * @author gpvkki
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	/**
     * Method to save the Role.
     * @param role Object
     * @return String as response
     */
	@PostMapping("/saverole")
	public String addRole(@RequestBody Role role) {
		roleService.saveRole(role);
		return "Role created successfully !!!";
	}
	
	/**
	 * Method to get the List of Roles.
     * @Return List with Role objects
	 * 
	 */
	@GetMapping("/getAll")
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}

}
