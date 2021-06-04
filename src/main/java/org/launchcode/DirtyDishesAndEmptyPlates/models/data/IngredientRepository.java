package org.launchcode.DirtyDishesAndEmptyPlates.models.data;

import org.launchcode.DirtyDishesAndEmptyPlates.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
  List<Ingredient> findByIngredientname(String ingredientName);
}

