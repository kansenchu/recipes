import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * レシピリクエストをやりとりために、必要なメッソドを示すインターフェース。
 */
public interface RecipeController {

  /**
   * 全レシピを取得する。
   * @return 全部のレシピが含めているレスポンス
   */
  @GetMapping
  public String getAllRecipes();

}