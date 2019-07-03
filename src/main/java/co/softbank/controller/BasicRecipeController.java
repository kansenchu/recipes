package co.softbank.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRecipeController implements RecipeController {

  @Override
  public String getAllRecipes() {
    return "";
  }

    
}