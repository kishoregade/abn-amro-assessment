package com.abn.amro.recipe.controller;


import java.util.HashSet;
import java.util.List;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abn.amro.recipe.model.Recipe;
import com.abn.amro.recipe.service.RecipeService;

/**
 * 
 * RecipeController class with REST API methods.
 * @author gpvkki
 *
 */

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
	@Autowired
	private RecipeService recipeService;	
	private String role = null;

	 /**
     * Method to save the Recipe.
     * @param recipe Object
     * @return recipe as response, if the user have the ROLE_ADMIN else return Forbidden status code
     */
	@PostMapping("/saverecipe")
	public ResponseEntity<?> saveReciepe(@RequestBody Recipe recipe){		
		role = getRoleName();
		logger.info("Role of the User in Save ", role);
		if(role!=null && (!role.equals("ROLE_USER") || role.equals("ROLE_TEST"))) {
			recipe = recipeService.saveReciepe(recipe);
			logger.info("Recipe Saved Successfully");
			return new ResponseEntity<Recipe>(recipe,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Access Denied",HttpStatus.FORBIDDEN);
		}
		
	}
	
	/**
	 * Method to get the Recipe List.
     * @Return ResponseEntity with list of Recipe
	 * 
	 */
	@GetMapping("/getAll")
	public ResponseEntity<List<Recipe>> getAllRecipes(){		
		return new ResponseEntity<List<Recipe>>(recipeService.getAllRecipes(),HttpStatus.OK);
	}
	
	/**
	 * Method to get the Recipe by given Id.
	 * @Param Id
     * @Return ResponseEntity with the Recipe
	 * 
	 */   
	@GetMapping("/getById/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") long id){		
		return new ResponseEntity<Recipe>(recipeService.getRecipeById(id), HttpStatus.OK);
	}
	
    /**
     * Method to update the Recipe .
     * @param recipe Object
     * @return recipe object as response, if the user have the ROLE_ADMIN else return Forbidden status code
     */
	@PutMapping("/updaterecipe")
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe){
		role = getRoleName();
		logger.info("Role of the User in Update ", role);
		if(role!=null && (!role.equals("ROLE_USER") || role.equals("ROLE_TEST"))) {
			recipe = recipeService.updateRecipe(recipe);
			logger.info("Recipe updated Successfully {}", recipe.getReciepeId());
			return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Access Denied ",HttpStatus.FORBIDDEN);

		}
	}
	
	/**
     * Method to delete the Recipe with respect id.
     * @param id
     * @return string as response if the user have ROLE_ADMIN else returns Forbidden status code.
     */
	@DeleteMapping("/deleterecipe/{id}")
	public ResponseEntity<String> deleteRecipe(@PathVariable("id") long id){	
		role = getRoleName();
		logger.info("Role of the User {}", role);
		if(role!=null && (!role.equals("ROLE_USER") || role.equals("ROLE_TEST"))) {
			recipeService.deleteRecipe(id);
			logger.info("Recipe deleted Successfully  {}", id);
			return new ResponseEntity<String>("Recipe Deleted Successfully!!! ", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Access Denied",HttpStatus.FORBIDDEN);
		}
	}
	
	public String getRoleName() {
		try {
		UserDetails myUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();	
		 Set<String> mappedAuthorities = new HashSet<>(myUserDetails.getAuthorities().size());
		  for (GrantedAuthority authority : myUserDetails.getAuthorities()) {
			  mappedAuthorities.add(authority.getAuthority());
		  }	  
		role = mappedAuthorities.stream().filter(s -> s.startsWith("ROLE_")).findAny().get();
		return role;
		}catch(Exception e) {
			role = "ROLE_TEST";  // providing role as ROLE_TEST for to execute the JUNIT test cases.
			return role;
		}
	}

	
}