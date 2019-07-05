package co.softbank.recieverecipe.responses;

import co.softbank.recieverecipe.models.Recipe;

import java.util.Arrays;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * 一個のレシピを返すレスポンスを表現するクラス。
 */
@EqualsAndHashCode
public class RecipeResponse {

  final String message;         /** 返すメッセージ。 */
  final List<Recipe> recipe;    /** 実際にレシピリスト。 */

  /**
   * コンストラクタ。レシピを自動でリスト化にします。
   */
  public RecipeResponse(String message, Recipe recipe) {
    this.message = message;
    this.recipe = Arrays.asList(recipe);
  }
}