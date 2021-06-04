package org.launchcode.DirtyDishesAndEmptyPlates.models;

import java.io.Serializable;
import java.util.Objects;


public class RecipeIngredientId implements Serializable {
  private int recipeid;
  private int ingredientline;

  public RecipeIngredientId() {
  }
  
  public RecipeIngredientId(int recipeid, int ingredientline) {
    this.recipeid = recipeid;
    this.ingredientline = ingredientline;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RecipeIngredientId that = (RecipeIngredientId) o;
    return (recipeid == that.recipeid) && (ingredientline == that.ingredientline);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(recipeid, ingredientline);
  }
  
}
