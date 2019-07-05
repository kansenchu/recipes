package co.softbank.recieverecipe.responses;

import co.softbank.recieverecipe.models.Recipe;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 全レシピを返す用のレスポンスPOJO。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllRecipeResponse {
  List<Recipe> recipes; /** レシピを格納するリスト */
}