package com.abn.amro.recipe.service.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abn.amro.recipe.exception.ResourceNotFoundException;
import com.abn.amro.recipe.model.Recipe;
import com.abn.amro.recipe.repository.RecipeRepository;
import com.abn.amro.recipe.service.RecipeService;
import com.abn.amro.recipe.util.Utility;

/**
 * This class is for all CRUD (Create/Read/Update/Delete Recipes) Operations.
 * No need of explicit mention of @Transactional since SimpleJPARepository class already annotated with @Repository and @Transactional.
 * @author gpvkki
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	/**
     * Method to save the Recipe
     * @param recipe 
     * @return recipe object.
     */
	@Override
	public Recipe saveReciepe(Recipe recipe) {
		// TODO Auto-generated method stub
		return recipeRepository.save(recipe);
	}

	/**
     * Method to get All Available Recipes.
     * 
     * @return List of Recipes .
     */
	@Override
	public List<Recipe> getAllRecipes() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	/**
     * Method to get the Recipe by given Recipe Id.
     * @param id 
     * @return recipe object.
     */

	@Override
	public Recipe getRecipeById(long id) {
		// TODO Auto-generated method stub
		/*Optional<Recipe> recipe = recipeRepository.findById(id);
		if(recipe.isPresent()) {
			return recipe.get(); // get method will return content of Optional - here Recipe object will be return from Optional.
		}else {
			throw new ResourceNotFoundException("Recipe Not Found By Id "+id);
		}*/
		
		/* by using lambda expression - it returns the Recipe object if the data will be available with given id 
		 or else it will throw the custom exception. */
		return recipeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Recipe not Found with Id "+id));
		
	}

	/**
     * Method to update the Recipe by Id.
     * @param recipe 
     * @return recipe object.
     */

	@Override
	public Recipe updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		Recipe updatedRecipe = recipeRepository.findById(recipe.getReciepeId()).orElseThrow(()->new ResourceNotFoundException("Recipe not Found with Id "+recipe.getReciepeId()));
		updatedRecipe = modelMapper.map(recipe, Recipe.class);
		recipeRepository.save(updatedRecipe);
		return updatedRecipe;
	}

	/**
     * Method to Delete the Recipe by given Recipe Id
     * @param id 
     * @return void.
     */

	@Override
	public void deleteRecipe(long id) {
		// TODO Auto-generated method stub
		 recipeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Recipe not Found with Id "+id));
		 recipeRepository.deleteById(id);
		
	} 
	

	
	
}
