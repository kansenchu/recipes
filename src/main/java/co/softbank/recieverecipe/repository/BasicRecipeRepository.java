package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BasicRecipeRepository implements RecipeRepository {

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Recipe> getAllRecipes() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe getRecipe(int id) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe addRecipe(Recipe newRecipe) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe editRecipe(int i, Recipe editedRecipe) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe deleteRecipe(int i) {
    return null;
  }

}