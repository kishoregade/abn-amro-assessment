package com.abn.amro.recipe.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abn.amro.recipe.model.User;
import com.abn.amro.recipe.repository.UserRepository;
import com.abn.amro.recipe.service.UserService;

/**
 * This class is for Create and List the Users.
 * @author gpvkki
 *
 */


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/**
     * Method to save the User
     * @param user 
     * @return User object.
     */
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
  
	/**
     * Method to get All Users.
     * 
     * @return List of users .
     */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}
  
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserName(userName).get();
		return user;
	}

	

}
