package co.softbank.recieverecipe.controller;

import co.softbank.recieverecipe.responses.AllRecipeResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * レシピリクエストをやりとりために、必要なメッソドを示すインターフェース。
 */
@RequestMapping("/recipes")
public interface RecipeController {

  /**
   * 全レシピを取得する。
   * @return 全部のレシピが含めているレスポンス
   */
  @GetMapping
  public AllRecipeResponse getAllRecipes();

}