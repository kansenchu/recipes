package co.softbank.recieverecipe.models;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

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
public class Recipe {
  private final int id;
  @NotNull
  private final String title;          /** レシピの名前。*/
  @NotNull
  private final String makingTime;     /** レシピの作り時間 。*/
  @NotNull
  private final String serves;         /** レシピに対応する人数。*/
  @NotNull
  private final String ingredients;    /** 材料リスト。Listではなく、String扱いとしています。*/
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