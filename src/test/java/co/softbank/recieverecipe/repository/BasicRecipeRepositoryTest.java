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
  public void addRecipe() {
    Recipe newRecipe = TestObjectRepo.newRecipe;
    basicRecipeRepo.addRecipe(newRecipe);
    assertEquals(newRecipe, basicRecipeRepo.getRecipe(newRecipe.getId()));
    assertEquals(TestObjectRepo.addedRecipeList, basicRecipeRepo.getAllRecipes());
  }

  @Test
  public void editRecipe() {
    Recipe editedRecipe = TestObjectRepo.editedRecipe;
    basicRecipeRepo.editRecipe(1, editedRecipe);
    assertEquals(editedRecipe, basicRecipeRepo.getRecipe(1));
    assertEquals(TestObjectRepo.editedRecipeList, basicRecipeRepo.getAllRecipes());
  }
}