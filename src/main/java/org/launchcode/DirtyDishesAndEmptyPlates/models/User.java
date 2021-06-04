package org.launchcode.DirtyDishesAndEmptyPlates.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

import static java.util.Objects.requireNonNullElse;

@Entity
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
  @Size(min=1, max=12)
  private String prefix;
  @Size(min=1, max=45)
  private String firstname;
  @Size(min=1, max=45)
  private String middlename;
  @Size(min=1, max=45)
  private String lastname;
  @Size(min=1, max=12)
  private String suffix;
  private Date dob;
  @Size(min=1, max=2048)
  private String bio;
  
  public User(String username, String password, Type type, String prefix, String firstname, String middlename, String lastname, String suffix,
              Date dob, String bio) {
    this.username = username;
    this.pwHash = encoder.encode(password);
    this.type = Objects.requireNonNullElse(type, Type.guest);
    this.prefix = prefix;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.suffix = suffix;
    this.dob = dob;
    this.bio = bio;
  }
  
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
  
  public String getPrefix() {
    return prefix;
  }
  
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  public String getMiddlename() {
    return middlename;
  }
  
  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public String getSuffix() {
    return suffix;
  }
  
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
  
  public Date getDob() {
    return dob;
  }
  
  public void setDob(Date dob) {
    this.dob = dob;
  }
  
  public String getBio() {
    return bio;
  }
  
  public void setBio(String bio) {
    this.bio = bio;
  }
  
}
