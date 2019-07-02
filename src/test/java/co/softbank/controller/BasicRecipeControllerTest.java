package co.softbank.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class BasicRecipeControllerTest {

  BasicRecipeController recipeController = new BasicRecipeController();

  @Test
  public void getAllRecipes() {
    assertEquals(recipeController.getAllRecipes(), "");
  }
}