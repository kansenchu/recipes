package co.softbank.recieverecipe.controller;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.repository.RecipeRepository;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicRecipeController implements RecipeController {

  final RecipeRepository recipeRepository;

  @Override
  public AllRecipeResponse getAllRecipes() {
    return new AllRecipeResponse(recipeRepository.getAllRecipes());
  }
    
}