package org.launchcode.DirtyDishesAndEmptyPlates.models;

public class GuestUser extends User {
  public GuestUser() {
    super.type = Type.guest;
    super.username = "Guest";
  }
  public void setUsername(String username) {
  }
  public void setType(Type type) {
  }
}
