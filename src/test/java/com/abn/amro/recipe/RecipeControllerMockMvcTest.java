package com.abn.amro.recipe;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.ResourceUtils;

import com.abn.amro.recipe.model.Recipe;
import com.abn.amro.recipe.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerMockMvcTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    RecipeService recipeService;

    @Autowired
    private ObjectMapper objectMapper;

    String getRequestJson() throws IOException {
        return Files.readString(Path.of("./src/test/resources/request.json"));
    }

    Recipe getRecipe() throws IOException {
    	//System.out.println(" OM "+objectMapper);
        return objectMapper.readValue(ResourceUtils.getFile("./src/test/resources/request.json"), Recipe.class);
    }

    @Test
    void addRecipeTest() throws Exception {
        //Given
        Recipe recipe = getRecipe();
        //When
        Mockito.when(recipeService.saveReciepe(recipe)).thenReturn(getRecipe());
        ResultActions resultActions = mockMvc.perform(
                post("/recipe/saverecipe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getRequestJson())
        );
                

        resultActions.andExpect(status().isCreated());
    }

    @Test
    void updateRecipeTest() throws Exception {
        //Given
        Recipe recipe = getRecipe();
        //When
        Mockito.when(recipeService.updateRecipe(recipe)).thenReturn(getRecipe());
        ResultActions resultActions = mockMvc.perform(
                put("/recipe/updaterecipe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getRequestJson())
        );
        //Then
        resultActions.andExpect(status().isOk());
    }

    @Test
    void selectRecipeTest() throws Exception {
        //Given
        Long recipeId = 1L;
        //When
        Mockito.when(recipeService.getRecipeById(recipeId)).thenReturn(getRecipe());
        ResultActions resultActions = mockMvc.perform(get("/recipe/getById/{id}",1l));

        //Then
        resultActions.andExpect(status().isOk());
    }

    @Test
    void selectListOfRecipesTest() throws Exception {
        //When
        Mockito.when(recipeService.getAllRecipes()).thenReturn(Stream.of(getRecipe()).collect(Collectors.toList()));
        ResultActions resultActions = mockMvc.perform(get("/recipe/getAll"));
        //Then
        resultActions.andExpect(status().isOk());
    }

    @Test
    void deleteRecipeTest() throws Exception {
        //Given
        Long recipeId = 1L;
        //When
        ResultActions resultActions = mockMvc.perform(delete("/recipe/deleterecipe/{id}", 1l)
        );
        //Then
        resultActions.andExpect(status().isOk());
    }

}


