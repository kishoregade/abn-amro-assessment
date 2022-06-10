package com.abn.amro.recipe.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abn.amro.recipe.model.Role;
import com.abn.amro.recipe.model.User;
import com.abn.amro.recipe.service.UserService;
/**
 * 
 * UserController class with REST API methods
 * @author gpvkki
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
  @Autowired
  private UserService userService;
  
  /**
   * Method to save the User.
   * @param user Object
   * @return String as response
   */
  @PostMapping("/saveuser")
  public String addUser(@RequestBody User user) {
	  userService.saveUser(user);
	  return "User created successfully !!! ";
  }
  
  /**
   * Method to get the List of Users.
   * @Return List with User objects
   * 
   */
  @GetMapping("/getAll")
  public List<User> getAllUsers(){
	  return userService.getAllUsers();
  }
  

 
}
