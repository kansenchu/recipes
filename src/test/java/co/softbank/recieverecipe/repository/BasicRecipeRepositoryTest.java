package co.softbank.recieverecipe.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.softbank.recieverecipe.TestObjectRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicRecipeRepositoryTest {

  BasicRecipeRepository basicRecipeRepo;

  @Test
  public void getRecipe() {
    assertEquals(basicRecipeRepo.getRecipe(1), TestObjectRepo.recipeOne);
  }
}