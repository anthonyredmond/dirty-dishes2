package org.launchcode.DirtyDishesAndEmptyPlates.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static java.util.Objects.requireNonNullElse;

@Entity
@Table(name="user")
public class User extends AbstractEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private int id;
  
  public enum Type {
    owner, admin, author, user, guest
  }
  @NotNull
  protected String username;
  @NotNull
  protected String pwHash;
  @NotNull
  @Enumerated(EnumType.STRING)
  protected Type type;
  
  public User(String username, String password, Type type) {
    this.username = username;
    this.pwHash = encoder.encode(password);
    this.type = Objects.requireNonNullElse(type, Type.guest);
  }
  
  public User(String username, String password) {
    this(username, password, Type.user);
  }
  
  public User(String username) {
    this(username, "");
  }
  
  public User(User user) {
    this.id = user.id;
    this.username = user.username;
    this.pwHash = user.pwHash;
    this.type = Objects.requireNonNullElse(type, Type.guest);
  }
  
  public User() {
  
  }
  
 
  public String getUsername() {
    return username;
  }
  
  public Type getType() {
    return type;
  }
  
  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
  public boolean isMatchingPassword(String password) {
    return encoder.matches(password, pwHash);
  }
  
 }
