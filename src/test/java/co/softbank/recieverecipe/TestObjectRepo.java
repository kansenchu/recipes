package co.softbank.recieverecipe;

import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.responses.AllRecipeResponse;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
  
  // public static Recipe newRecipe = new Recipe(
  //   3,
  //   "豚骨ラーメン",
  //   "8時間",
  //   "100人",
  //   "玉ねぎ,肉,スパイス",
  //   "50000",
  //   new Timestamp(Instant.now().getEpochSecond()),
  //   new Timestamp(Instant.now().getEpochSecond())
  // );
  // public static RecipeDto newRecipeDto = newRecipe.mapToDto();
  
  // public static Recipe newRecipeNoTimestamp = Recipe.builder()
  //     .title("豚骨ラーメン")
  //     .makingTime("8時間")
  //     .serves("100人")
  //     .ingredients("玉ねぎ,肉,スパイス")
  //     .cost("50000")
  //     .build();
  // public static RecipeDto newRecipeNoId = RecipeDto.builder()
  //     .title("豚骨ラーメン")
  //     .makingTime("8時間")
  //     .serves("100人")
  //     .ingredients("玉ねぎ,肉,スパイス")
  //     .cost("50000")
  //     .build();
  
  // public static List<Recipe> allRecipes = Arrays.asList(
  //     oneRecipe,
  //     new Recipe(
  //         2,
  //         "オムライス",
  //         "30分",
  //         "2人",
  //         "玉ねぎ,卵,スパイス,醤油",
  //         "700",
  //         new Timestamp(getMillisecondFromDateString("2016-01-11 13:10:12")),
  //         new Timestamp(getMillisecondFromDateString("2016-01-11 13:10:12"))
  //     )
  // );
  // public static List<RecipeDto> allRecipesDto = allRecipes.stream()
  //     .map(Recipe::mapToDto).collect(Collectors.toList());
  
  // public static Recipe editedRecipe = new Recipe(
  //     1,
  //     "豚骨ラーメン",
  //     "8時間",
  //     "100人",
  //     "玉ねぎ,肉,スパイス",
  //     "50000",
  //     new Timestamp(getMillisecondFromDateString("2016-01-10 12:10:12")),
  //     new Timestamp(getMillisecondFromDateString("2016-01-10 12:10:12"))
  // );
  // public static RecipeDto editedRecipeDto = editedRecipe.mapToDto();
  
  // public static MultiRecipeResponse allRecipesResponse = new MultiRecipeResponse(allRecipesDto);
  // public static SuccessResponse getOneResponse = new SuccessResponse(SuccessResponse.Message.RETRIEVED, TestObjectRepository.oneRecipeDto);
  // public static SuccessResponse addOneResponse = new SuccessResponse(SuccessResponse.Message.CREATED, TestObjectRepository.newRecipeDto);
  // public static SuccessResponse addOneResponseWithoutId = new SuccessResponse(SuccessResponse.Message.CREATED, TestObjectRepository.newRecipeNoId);
  // public static SuccessResponse editedResponse = new SuccessResponse(SuccessResponse.Message.UPDATED, TestObjectRepository.editedRecipeDto);
  // public static SuccessResponse deletedResponse = new SuccessResponse(SuccessResponse.Message.DELETED);
  
  // public static ErrorResponse notFoundResponse = new ErrorResponse(ErrorResponse.Message.NOT_FOUND);
  
  // public static String allFieldsMissingStr = "title, making_time, serves, ingredients, cost";
  // public static ErrorResponse invalidRecipeResponse = new ErrorResponse(ErrorResponse.Message.CREATION_FAILED, allFieldsMissingStr);
  
  private static long getMillisecondFromDateString(String dateString) {
    return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
             .atZone(ZoneId.systemDefault()).toEpochSecond();
  }
}
