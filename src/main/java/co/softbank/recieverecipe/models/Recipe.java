package co.softbank.recieverecipe.models;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DBとやりとりする時使うレシピクラス。
 * ポイントとして、cost (値段)がintの基準でしています。
 * @author pikachoo
 *
 */
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Recipe {
  @NotNull
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
}