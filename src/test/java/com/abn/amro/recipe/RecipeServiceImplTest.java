package com.abn.amro.recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.ResourceUtils;

import com.abn.amro.recipe.model.Ingrediants;
import com.abn.amro.recipe.model.Recipe;
import com.abn.amro.recipe.repository.RecipeRepository;
import com.abn.amro.recipe.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeServiceImplTest {
	
	@Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RecipeService recipeService;

    @MockBean
    RecipeRepository recipeRepository;

    Ingrediants ingrediants;
    Recipe recipe;

    @BeforeEach
    public void setUp() throws IOException {
        recipe = getrecipe();
        ingrediants = new Ingrediants();
        ingrediants.setName("Oil");
        ingrediants.setId(recipe.getReciepeId());
        Set<Ingrediants> ingridientEntities = new HashSet<Ingrediants>();
        ingridientEntities.add(ingrediants);

    }


    Recipe getrecipe() throws IOException {
        return objectMapper.readValue(ResourceUtils.getFile("./src/test/resources/request.json"), Recipe.class);
    }

    @Test
    void addRecipeTest() throws Exception {
        Mockito.when(recipeRepository.save(Mockito.any())).thenReturn(recipe);
        Recipe response= recipeService.saveReciepe(recipe);
        assertEquals("Mutton", response.getReciepeName());
    }

    @Test
    void updateRecipeTest() throws Exception {

        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(recipe));
        Mockito.when(recipeRepository.save(Mockito.any())).thenReturn(recipe);

        Recipe responseDTO = recipeService.updateRecipe(recipe);
        assertEquals("Mutton", responseDTO.getReciepeName());
    }

    @Test
    void getRecipeByIDTest() throws Exception {

        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(recipe));
        Recipe response = recipeService.getRecipeById(1l);
        assertEquals("Mutton", response.getReciepeName());
    }

    @Test
    void getRecipeAllTest() throws Exception {
        List<Recipe> listRecipe = new ArrayList<Recipe>();
        listRecipe.add(recipe);
        Mockito.when(recipeRepository.findAll()).thenReturn(listRecipe);
        List<Recipe> listrecipe = recipeService.getAllRecipes();
        assertTrue(listrecipe.size() > 0);
    }

    @Test
    void getDeleteTest() throws Exception {
        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(recipe));
        recipeRepository.deleteById(1l);
        recipeService.deleteRecipe(1l);
        assertTrue(true);
    }

}
