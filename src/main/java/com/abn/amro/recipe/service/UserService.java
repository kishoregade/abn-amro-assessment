package com.abn.amro.recipe.service;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.model.User;


public interface UserService {

	User saveUser(User user); 
	List<User> getAllUsers();
	User findByUserName(String userName) ;
	
}
