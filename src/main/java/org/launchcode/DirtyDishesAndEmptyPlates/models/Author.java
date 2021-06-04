package org.launchcode.DirtyDishesAndEmptyPlates.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Author extends User {
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
  @OneToMany(targetEntity = Recipe.class, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.DETACH,
    CascadeType.REFRESH})
  @JoinTable(
    name="recipeauthors",
    joinColumns=
    @JoinColumn( name="recipeauthors_users", referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="recipeauthors_recipe", referencedColumnName="id"
    )
  )
  private List<Recipe> recipes;
  
   public Author() {
     super();
   }
  
  public Author(User user) {
    super(user);
  }
  
  public Author(User user, String prefix, String firstname, String middlename, String lastname, String suffix,
                Date dob, String bio) {
    super(user);
    this.prefix = prefix;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.suffix = suffix;
    this.dob = dob;
    this.bio = bio;
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
