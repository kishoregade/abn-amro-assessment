package com.abn.amro.recipe.service;

import java.util.List;

import com.abn.amro.recipe.model.Recipe;

public interface RecipeService {

	Recipe saveReciepe(Recipe recipe);
	List<Recipe> getAllRecipes();
	Recipe getRecipeById(long id);
	Recipe updateRecipe(Recipe recipe);
	void deleteRecipe(long id);
}
