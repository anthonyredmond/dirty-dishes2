package org.launchcode.DirtyDishesAndEmptyPlates.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {
  public enum Type {
    vegetable, fruit, grain, dairy, protein, fat
  }
  @NotNull
  @Size(min=3, max=32)
  private String ingredientname;
  @NotNull @Size(min=1, max=32)
  private String prep;
  @Size(min=3, max=32)
  private String ingredientdescription;
  private Type ingredienttype;
}

