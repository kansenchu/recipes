package co.softbank.recieverecipe.repository;

import co.softbank.recieverecipe.models.Recipe;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
      newRecipe.getParamsAsArray().toArray());
    return getRecipe(newRecipe.getId());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe editRecipe(int id, Recipe editedRecipe) {
    ArrayList<Object> params = editedRecipe.getParamsAsArray();
    params.add(id);
    jdbcTemplate.update("UPDATE recipes SET title = ?, making_time = ?,"
      + " serves = ?, ingredients = ?, cost = ?,"
      + " created_at = ?, updated_at = ? WHERE id = ?",
      params.toArray());
    return jdbcTemplate.queryForObject("SELECT * FROM recipes WHERE id = ?", 
      new Object[] {id},
      new RecipeMapper());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Recipe deleteRecipe(int id) {
    Recipe toBeDeleted = getRecipe(id);
    jdbcTemplate.update("DELETE FROM recipes WHERE id = ?", new Object[] {id});
    return toBeDeleted;
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