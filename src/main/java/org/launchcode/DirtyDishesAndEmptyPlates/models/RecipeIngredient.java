package org.launchcode.DirtyDishesAndEmptyPlates.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="recipeingredient")
public class RecipeIngredient extends AbstractEntity {
  @NotNull
  private int recipeid;
  @NotNull
  private int ingredientline;
  @NotNull
  private int ingredientid;
  @NotNull
  @Size(min=1, max=10)
  private String qty;
  @Size(min=1, max=10)
  private String uom;
  @Size(max=64)
  private String instruction;
  
  public RecipeIngredient() {
  
  }
  
  public RecipeIngredient(int recipeid, int ingredientid, int ingredientline, String qty, String uom,
                          String instruction) {
    this.recipeid=recipeid;
    this.ingredientid=ingredientid;
    this.ingredientline=ingredientline;
    this.qty=qty;
    this.uom=uom;
    this.instruction=instruction;
  }

  public int getIngredientline() {
    return ingredientline;
  }

  public void setIngredientline(int ingredientline) {
    this.ingredientline = ingredientline;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }
  
}
