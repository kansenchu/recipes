package co.softbank.recieverecipe.models;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import co.softbank.recieverecipe.models.views.RecipeViews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * DBとやりとりする時使うレシピクラス。
 * ポイントとして、cost (値段)がintの基準でしています。
 * @author pikachoo
 *
 */
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@JsonTypeName("recipe")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
  @JsonView(RecipeViews.IncludeId.class)
  private final int id;
  
  @JsonView(RecipeViews.ExcludeId.class)
  @NotNull
  private final String title;          /** レシピの名前。*/
  
  @JsonView(RecipeViews.ExcludeId.class)
  @NotNull
  private final String makingTime;     /** レシピの作り時間 。*/

  @JsonView(RecipeViews.ExcludeId.class)
  @NotNull
  private final String serves;         /** レシピに対応する人数。*/

  @JsonView(RecipeViews.ExcludeId.class)
  @NotNull
  private final String ingredients;    /** 材料リスト。Listではなく、String扱いとしています。*/

  @JsonView(RecipeViews.ExcludeId.class)
  @NotNull
  private final int cost;              /** レシピの予測値段。*/

  /** レシピの作成時間。 */ 
  private Timestamp createdAt;

  /** レシピの作成時間。 */
  private Timestamp updatedAt;

  public int getId() { 
    return id; 
  }

  /**
   * レシピのデータをDBに入れるためObject型のArrayListに変換する。
   * @return
   */
  public ArrayList<Object> getParamsAsArray() {
    ArrayList<Object> result = new ArrayList<>();
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      try {
        Object value = field.get(this);
        if (field.getType().isPrimitive()) {
          if (((Number) value).doubleValue() != 0) {
            result.add(value);
          }
        } else if (value != null) {
          result.add(value);
        }
      } catch (IllegalArgumentException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
}