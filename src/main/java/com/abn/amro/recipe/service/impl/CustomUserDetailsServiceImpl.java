package com.abn.amro.recipe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abn.amro.recipe.exception.ResourceNotFoundException;
import com.abn.amro.recipe.model.User;
import com.abn.amro.recipe.repository.UserRepository;

/**
 * CustomUserDetailsServiceImpl class implemented UserDetailsService to retrieve user related data.
 * UserDetailsService interface has one method called loadUserByUsername and implemented in this class and returns UserDetails Object 
 * @author gpvkki
 *
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		 User userObj =  repository.findByUserName(username).orElseThrow(()->new ResourceNotFoundException(username+" Not Found"));	 		  
		 return new CustomUserDetailsImpl(userObj);
	}

}
