package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(controllers = RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @MockBean
    private RecipeEntityMapper mapper;
    @MockBean
    private ch.tbz.recipe.planner.repository.RecipeRepository recipeRepository;

    @Test
    void getAllRecipes_returnsStatusOk() throws Exception {
        Mockito.when(service.getRecipes()).thenReturn(List.of(new Recipe()));

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk());
    }

    @Test
    void getRecipeById_returnsStatusOk() throws Exception {
        UUID id = UUID.randomUUID();
        Mockito.when(service.getRecipeById(id)).thenReturn(new Recipe());

        mockMvc.perform(get("/api/recipes/recipe/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    void addRecipe_returnsStatusOk() throws Exception {
        Mockito.when(service.addRecipe(any(Recipe.class))).thenReturn(new Recipe());

        String json = """
            {
              "name": "Test",
              "description": "Testbeschreibung",
              "imageUrl": "test.jpg",
              "ingredients": []
            }
            """;

        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}
