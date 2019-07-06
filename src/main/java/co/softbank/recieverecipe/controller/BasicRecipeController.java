package co.softbank.recieverecipe.controller;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.repository.RecipeRepository;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import co.softbank.recieverecipe.responses.RecipeResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

/**
 * 基本のレシピコントローラを示すクラス。
 */
@RestController
@RequiredArgsConstructor
public class BasicRecipeController implements RecipeController {

  final RecipeRepository recipeRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public AllRecipeResponse getAllRecipes() {
    return new AllRecipeResponse(recipeRepository.getAllRecipes());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RecipeResponse getRecipe(int id) {
    return new RecipeResponse("", recipeRepository.getRecipe(id));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RecipeResponse addRecipe(Recipe newRecipe) {
    recipeRepository.addRecipe(newRecipe);
    return new RecipeResponse("", null);
  }
    
}