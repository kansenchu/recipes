package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;

import java.util.List;

/**
 * データベースとレシピをやりとりするクラス。
 */
public interface RecipeRepository {
  /**
   * 全レシピを取得して、リスト方式で返す。
   */
  public List<Recipe> getAllRecipes();

  /**
   * 指定したレシピをデータベースから取ってきて、返す。
   * @param id 取得したいレシピのid
   * @return 指定したレシピオブジェクト
   */
  public Recipe getRecipe(int id);

  /**
   * レシピを追加するメソッド。
   * @param newRecipe 新しいレシピのオブジェクト
   * @return 実際に保存されたレシピオブジェクト
   */
  public Recipe addRecipe(Recipe newRecipe);

  public void editRecipe(int i, Recipe editedRecipe);

}