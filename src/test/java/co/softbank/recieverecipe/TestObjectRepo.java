package co.softbank.recieverecipe;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.responses.AllRecipeResponse;
import co.softbank.recieverecipe.responses.RecipeResponse;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * テストオブジェクトを作成、保存するクラス。
 */
public class TestObjectRepo {
  public static Recipe recipeOne = Recipe.builder()
      .id(1)
      .title("チキンカレー")
      .makingTime("45分")
      .serves("4人")
      .ingredients("玉ねぎ,肉,スパイス")
      .cost(1000)
      .createdAt(new Timestamp(getMillisecondFromDateString("2016-01-10 12:10:12")))
      .updatedAt(new Timestamp(getMillisecondFromDateString("2016-01-10 12:10:12")))
      .build();

  public static Recipe recipeTwo = Recipe.builder()
    .id(2)
    .title("オムライス")
    .makingTime("30分")
    .serves("2人")
    .ingredients("玉ねぎ,卵,スパイス,醤油")
    .cost(700)
    .createdAt(new Timestamp(getMillisecondFromDateString("2016-01-11 13:10:12")))
    .updatedAt(new Timestamp(getMillisecondFromDateString("2016-01-11 13:10:12")))
    .build();

  public static Recipe newRecipe = Recipe.builder()
    .id(3)
    .title("豚骨ラーメン")
    .makingTime("8時間")
    .serves("100人")
    .ingredients("玉ねぎ,肉,スパイス")
    .cost(50000)
    .createdAt(new Timestamp(Instant.now().getEpochSecond()))
    .updatedAt(new Timestamp(Instant.now().getEpochSecond()))
    .build();

  public static List<Recipe> baseRecipeList = Arrays.asList(recipeOne, recipeTwo);
  public static AllRecipeResponse baseAllRecipesResponse = new AllRecipeResponse(baseRecipeList);

  public static RecipeResponse recipeOneResponse = new RecipeResponse("", TestObjectRepo.recipeOne);
  
  private static long getMillisecondFromDateString(String dateString) {
    return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
             .atZone(ZoneId.systemDefault()).toEpochSecond();
  }
}
