package co.softbank.recieverecipe.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import co.softbank.recieverecipe.TestObjectRepo;
import co.softbank.recieverecipe.repository.RecipeRepository;
import co.softbank.recieverecipe.responses.RecipeResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class BasicRecipeControllerTest {

  @Mock
  RecipeRepository recipeRepository;

  @InjectMocks
  BasicRecipeController recipeController;

  @Test
  public void getAllRecipes() {
    when(recipeRepository.getAllRecipes()).thenReturn(TestObjectRepo.baseRecipeList);
    assertEquals(recipeController.getAllRecipes(), TestObjectRepo.baseAllRecipesResponse);
  }

  @Test
  public void getOneRecipe() {
    assertEquals(recipeController.getRecipe(), new RecipeResponse("", Arrays.asList(TestObjectRepo.recipeOne)));
  }

}