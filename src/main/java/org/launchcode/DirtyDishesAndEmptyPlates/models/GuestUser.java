package org.launchcode.DirtyDishesAndEmptyPlates.models;

public class GuestUser extends User {
  public GuestUser() {
    this.type = Type.guest;
    this.username = "Guest";
  }
  
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
  }
  
  public Type getType() {
    return this.type;
  }
  
  public void setType(Type type) {
  }
}
