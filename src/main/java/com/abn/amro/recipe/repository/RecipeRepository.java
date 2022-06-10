package com.abn.amro.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abn.amro.recipe.model.Recipe;

/**
 * 
 * No need of explicit mention of @Repository since SimpleJPARepository class already annotated with @Repository and @Transactional.
 * @author gpvkki
 *
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	

}
