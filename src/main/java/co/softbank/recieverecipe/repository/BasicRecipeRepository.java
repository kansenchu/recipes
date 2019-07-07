package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BasicRecipeRepository implements RecipeRepository {

  final JdbcTemplate jdbcTemplate;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Recipe> getAllRecipes() {
    return jdbcTemplate.query("SELECT * FROM recipes", (rs) -> {
      List<Recipe> result = new ArrayList<>();
      while (rs.next()) {
        Recipe incomingRecipe = extractRecipeFromResultSet(rs);
        result.add(incomingRecipe);
      }
      return result;
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe getRecipe(int id) {
    return jdbcTemplate.query("SELECT * FROM recipes WHERE id = 1", (rs) -> {
      rs.next();
      return extractRecipeFromResultSet(rs);
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe addRecipe(Recipe newRecipe) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe editRecipe(int i, Recipe editedRecipe) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe deleteRecipe(int i) {
    return null;
  }

  private Recipe extractRecipeFromResultSet(ResultSet rs) throws SQLException {
    return Recipe.builder()
        .id(rs.getInt("id"))
        .title(rs.getString("title"))
        .makingTime(rs.getString("making_time"))
        .serves(rs.getString("serves"))
        .ingredients((rs.getString("ingredients")))
        .cost(rs.getInt("cost"))
        .createdAt(rs.getTimestamp("created_at"))
        .updatedAt(rs.getTimestamp("updated_at"))
        .build();
  }

}