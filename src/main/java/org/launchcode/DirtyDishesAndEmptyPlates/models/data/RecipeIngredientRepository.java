package org.launchcode.DirtyDishesAndEmptyPlates.models.data;

import org.launchcode.DirtyDishesAndEmptyPlates.models.Ingredient;
import org.launchcode.DirtyDishesAndEmptyPlates.models.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {
//  List<Ingredient> findByIngredientname(String ingredientName);
}
