package co.softbank.recieverecipe.controller;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.models.views.ResponseViews;
import co.softbank.recieverecipe.repository.RecipeRepository;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import co.softbank.recieverecipe.responses.RecipeResponse;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
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
  @JsonView(ResponseViews.MessageWithRecipe.class)
  public RecipeResponse getRecipe(int id) {
    return new RecipeResponse(RecipeResponse.Message.RETRIEVED, recipeRepository.getRecipe(id));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @JsonView(ResponseViews.MessageWithRecipe.class)
  public RecipeResponse addRecipe(Recipe newRecipe) {
    return new RecipeResponse(RecipeResponse.Message.CREATED, recipeRepository.addRecipe(newRecipe));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @JsonView(ResponseViews.MessageWithRecipe.class)
  public RecipeResponse editRecipe(int id, Recipe editedRecipe) {
    return new RecipeResponse(RecipeResponse.Message.UPDATED, recipeRepository.editRecipe(id, editedRecipe));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @JsonView(ResponseViews.MessageOnly.class)
  public RecipeResponse deleteRecipe(int i) {
    return new RecipeResponse(RecipeResponse.Message.DELETED, recipeRepository.deleteRecipe(i));
  }
    
}