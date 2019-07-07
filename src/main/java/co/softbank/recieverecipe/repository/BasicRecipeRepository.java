package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    return jdbcTemplate.query("SELECT * FROM recipes", new RecipeMapper());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe getRecipe(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM recipes WHERE id = ?", new Object[] {id},
      new RecipeMapper());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe addRecipe(Recipe newRecipe) {
    jdbcTemplate.update("INSERT INTO recipes VALUES (?, ?, ?, ?, ?, ?, ? ,?)",
      newRecipe.getParamsAsArray());
    return jdbcTemplate.queryForObject("SELECT * FROM recipes WHERE id = ?", 
      new Object[] {newRecipe.getId()},
      new RecipeMapper());
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

  private class RecipeMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
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

}