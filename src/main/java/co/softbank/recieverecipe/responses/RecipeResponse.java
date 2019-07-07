package co.softbank.recieverecipe.responses;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.models.views.ResponseViews;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Arrays;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * 一個のレシピを返すレスポンスを表現するクラス。
 */
@EqualsAndHashCode
public class RecipeResponse {

  @JsonView(ResponseViews.MessageOnly.class)
  final Message message;         /** 返すメッセージ。 */
  
  @JsonView(ResponseViews.MessageWithRecipe.class)
  final List<Recipe> recipe;    /** 実際にレシピリスト。 */

  public enum Message {
    RETRIEVED("Recipe details by id"),
    CREATED("Recipe successfully created!"),
    UPDATED("Recipe successfully updated!"),
    DELETED("Recipe successfully removed!");

    private String message;
    
    private Message(String message) {
      this.message = message;
    }

    @JsonValue
    public String getMessage() {
      return message;
    }
  }

  /**
   * コンストラクタ。レシピを自動でリスト化にします。
   */
  public RecipeResponse(Message message, Recipe recipe) {
    this.message = message;
    this.recipe = Arrays.asList(recipe);
  }
}