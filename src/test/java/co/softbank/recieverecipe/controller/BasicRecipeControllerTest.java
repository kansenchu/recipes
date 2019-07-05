package co.softbank.recieverecipe.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.repository.RecipeRepository;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import co.softbank.recieverecipe.TestObjectRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class BasicRecipeControllerTest {

  @Mock
  RecipeRepository recipeRepository;

  BasicRecipeController recipeController = new BasicRecipeController(recipeRepository);

  @Test
  public void getAllRecipes() {
    when(recipeRepository.getAllRecipes()).thenReturn(TestObjectRepo.baseRecipeList);
    assertEquals(recipeController.getAllRecipes(), TestObjectRepo.baseAllRecipesResponse);
  }

}