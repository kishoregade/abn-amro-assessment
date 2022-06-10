package com.abn.amro.recipe.service;


import java.util.List;
import com.abn.amro.recipe.model.User;

public interface UserService {

	User saveUser(User user); 
	List<User> getAllUsers();
	User findByUserName(String userName) ;
	
}
