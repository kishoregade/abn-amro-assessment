package com.abn.amro.recipe.service.impl;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.model.User;
import com.abn.amro.recipe.repository.UserRepository;
import com.abn.amro.recipe.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

	@Override
	public User getLoggedinUser(Principal principal) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(principal.getName()).get();
	}

	@Override
	public String getRolesByLoggedInUser(List<Role> rolesList) {
		// TODO Auto-generated method stub	
		//Collection<Role> rolesList = getLoggedinUser(principal).getRoles();
		 for (Role role : rolesList) {
			if(role.getRolename().equals("ROLE_USER")) 
				return "ROLE_USER";
			else 
				return "ROLE_ADMIN";
		 }
		 
		 return null;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserName(userName).get();
		return user;
	}

	

}
