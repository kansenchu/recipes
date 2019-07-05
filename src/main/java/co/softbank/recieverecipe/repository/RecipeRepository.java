package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;

import java.util.List;

public interface RecipeRepository {
  public List<Recipe> getAllRecipes();
}