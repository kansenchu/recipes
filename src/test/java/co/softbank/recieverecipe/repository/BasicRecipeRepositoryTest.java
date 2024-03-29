package co.softbank.recieverecipe.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import co.softbank.recieverecipe.TestObjectRepo;
import co.softbank.recieverecipe.models.Recipe;
import co.softbank.recieverecipe.repository.BasicRecipeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicRecipeRepositoryTest {

  @Autowired
  BasicRecipeRepository basicRecipeRepo;

  @Test
  public void getAllRecipes() {
    List<Recipe> list = basicRecipeRepo.getAllRecipes();
    assertEquals(list, TestObjectRepo.baseRecipeList);
  }

  @Test
  public void getRecipe() {
    assertEquals(basicRecipeRepo.getRecipe(1), TestObjectRepo.recipeOne);
  }

  @Test
  @DirtiesContext
  public void addRecipe() {
    Recipe newRecipe = TestObjectRepo.newRecipe;
    Recipe actual = basicRecipeRepo.addRecipe(newRecipe);
    assertEquals(newRecipe, actual);
    assertEquals(TestObjectRepo.addedRecipeList, basicRecipeRepo.getAllRecipes());
  }

  @Test
  @DirtiesContext
  public void editRecipe() {
    Recipe actual = basicRecipeRepo.editRecipe(1, TestObjectRepo.editRecipeData);
    assertEquals(TestObjectRepo.editedRecipe, actual);
    assertEquals(TestObjectRepo.editedRecipeList, basicRecipeRepo.getAllRecipes());
  }

  @Test
  @DirtiesContext
  public void deleteRecipe() {
    Recipe actual = basicRecipeRepo.deleteRecipe(1);
    assertEquals(TestObjectRepo.recipeOne, actual);
    assertEquals(TestObjectRepo.deletedRecipeList, basicRecipeRepo.getAllRecipes());
  }
}