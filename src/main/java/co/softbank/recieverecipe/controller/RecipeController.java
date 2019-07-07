package co.softbank.recieverecipe.controller;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import co.softbank.recieverecipe.responses.RecipeResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  /**
   * 指定したレシピを返すメソッド。
   * @param id 取得したいレシピのid
   * @return 取得したいレシピを包むレスポンス。
   */
  @GetMapping("/{id}")
  public RecipeResponse getRecipe(@PathVariable int id);

  /**
   * 新しいレシピを登録するメソッド。
   * @param recipe 追加したいレシピオブジェクト
   * @return 登録したレシピのレスポンス
   */
  @PostMapping
  public RecipeResponse addRecipe(@RequestBody Recipe recipe);

  /**
   * レシピを変換することを取り受けるメソッド。
   * @param id 変換したいレシピのid
   * @param recipe 変更したレシピの情報
   * @return 変更したレシピ
   */
  @PatchMapping("/{id}")
  public RecipeResponse editRecipe(@PathVariable int id, @RequestBody Recipe recipe);

  /**
   * レシピを削除するメソッド。
   * @param id 削除したいレシピのid
   * @return 削除されたレシピの情報を含んでるレスポンス
   */
  @DeleteMapping("/{id}")
  public RecipeResponse deleteRecipe(@PathVariable int id);
}