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
    .createdAt(getMillisecondFromDateString("2016-01-10 12:10:12"))
    .updatedAt(getMillisecondFromDateString("2016-01-10 12:10:12"))
    .build();

  public static Recipe recipeTwo = Recipe.builder()
    .id(2)
    .title("オムライス")
    .makingTime("30分")
    .serves("2人")
    .ingredients("玉ねぎ,卵,スパイス,醤油")
    .cost(700)
    .createdAt(getMillisecondFromDateString("2016-01-11 13:10:12"))
    .updatedAt(getMillisecondFromDateString("2016-01-11 13:10:12"))
    .build();

  private static Recipe.RecipeBuilder newRecipeBase = Recipe.builder()
    .title("豚骨ラーメン")
    .makingTime("8時間")
    .serves("100人")
    .ingredients("玉ねぎ,肉,スパイス")
    .cost(50000)
    .createdAt(new Timestamp(Instant.now().getEpochSecond()))
    .updatedAt(new Timestamp(Instant.now().getEpochSecond()));

  public static Recipe editRecipeData = newRecipeBase.build();
  public static Recipe newRecipe = newRecipeBase.id(3).build();
  public static Recipe editedRecipe = newRecipeBase.id(1).build();

  public static List<Recipe> baseRecipeList = Arrays.asList(recipeOne, recipeTwo);
  public static AllRecipeResponse baseAllRecipesResponse = new AllRecipeResponse(baseRecipeList);

  public static List<Recipe> addedRecipeList = Arrays.asList(recipeOne, recipeTwo, newRecipe);
  public static List<Recipe> editedRecipeList = Arrays.asList(editedRecipe, recipeTwo);
  public static List<Recipe> deletedRecipeList = Arrays.asList(recipeTwo);

  public static RecipeResponse recipeOneResponse = new RecipeResponse(RecipeResponse.Message.RETRIEVED, TestObjectRepo.recipeOne);
  public static RecipeResponse deletedRecipeOneResponse = new RecipeResponse(RecipeResponse.Message.DELETED, TestObjectRepo.recipeOne);
  public static RecipeResponse newRecipeResponse = new RecipeResponse(RecipeResponse.Message.CREATED, TestObjectRepo.newRecipe);
  public static RecipeResponse editedRecipeResponse = new RecipeResponse(RecipeResponse.Message.UPDATED, TestObjectRepo.editedRecipe);
  
  private static Timestamp getMillisecondFromDateString(String dateString) {
    return Timestamp.valueOf(LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
  }
}
