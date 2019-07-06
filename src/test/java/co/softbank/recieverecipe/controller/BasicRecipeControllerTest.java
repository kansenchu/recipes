package co.softbank.recieverecipe.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import co.softbank.recieverecipe.TestObjectRepo;
import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.repository.RecipeRepository;

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
    when(recipeRepository.getRecipe(1)).thenReturn(TestObjectRepo.recipeOne);
    assertEquals(recipeController.getRecipe(1), TestObjectRepo.recipeOneResponse);
  }

  @Test
  public void addRecipe() {
    when(recipeRepository.addRecipe(TestObjectRepo.newRecipe)).thenReturn(TestObjectRepo.newRecipe);
    assertEquals(recipeController.addRecipe(TestObjectRepo.newRecipe), TestObjectRepo.newRecipeResponse);
  }

  @Test
  public void editRecipe() {
    when(recipeRepository.editRecipe(1, TestObjectRepo.newRecipe)).thenReturn(TestObjectRepo.editedRecipe);
    assertEquals(recipeController.editRecipe(1, TestObjectRepo.newRecipe), TestObjectRepo.editedRecipeResponse);
  }

}