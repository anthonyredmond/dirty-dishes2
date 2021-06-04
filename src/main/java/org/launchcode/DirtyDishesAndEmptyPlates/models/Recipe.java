package org.launchcode.DirtyDishesAndEmptyPlates.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {
  public enum Serveqtytype {
    people, adults, children, infants;
  }
  @NotNull
  @Size(min=1, max=64)
  private String title;
  private Date versiondate;
  @Size(min=1, max=10)
  private String version;
  private Integer serveqty;
  @Enumerated(EnumType.STRING)
  private Serveqtytype serveqtytype;
  private Integer preptime;
  private Integer cooktime;
  @Size(min=1, max=10)
  private String portion;
  @Size(min=1, max=10)
  private String portionuom;
  @Size(min=1, max=2048)
  private String description;
  @Size(min=1, max=500)
  private String descriptionbrief;
  private boolean featured;
  @Size(min=3, max=164)
  private String image;
  private String instructions;
  
  public Recipe() {
  }
  
  // Initialize the id and value fields.
  public Recipe(String title, Integer serves, Serveqtytype servedTo, Integer thePrepTime,
                Integer theCookTime, String portionSize, String description, String descriptionbrief) {
    super();
    this.title = title;
    this.description = description;
    this.serveqty = serves;
    this.serveqtytype = servedTo;
    this.preptime = thePrepTime;
    this.cooktime = theCookTime;
    this.portion = portionSize;
    this.description = description;
    this.descriptionbrief = descriptionbrief;
    this.featured=featured;
    this.image=image;
    this.instructions=instructions;
  }
  
  // Getters and setters.
  
  public String getTitle() {
    if (title != null) {
      return title;
    } else return "";
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getVersion() {
    return version;
  }
  
  public void setVersion(String version) {
    this.version = version;
  }
  
  public Integer getServeqty() {
    return serveqty;
  }
  
  public void setServeqty(Integer serveqty) {
    this.serveqty = serveqty;
  }
  
  public Serveqtytype getServeqtytype() {
    return serveqtytype;
  }
  
  public void setServeqtytype(Serveqtytype serveqtytype) {
    this.serveqtytype = serveqtytype;
  }
  
  public String serves() {
    if (serveqty != null) {
      String out = String.valueOf(this.serveqty);
      if (serveqtytype != null)
        out += " " + serveqtytype;
      return out;
    } else
      return "";
  }
  
  public String servesCompressed() {
    if (serveqty != null) {
      String
        out = String.valueOf(this.serveqty),
        sqt = "";
      if (serveqtytype != null)
      switch(serveqtytype) {
        case adults:
          sqt = "a";
          break;
        case children:
          sqt = "c";
          break;
        case infants:
          sqt = "i";
          break;
        default:
          sqt = "p";
        
      }
      out += " " + sqt;
      return out;
    } else
      return "";
  }
  
  public Integer getPreptime() {
    return preptime;
  }
  
  private String fmtTime(int minutes) {
    int hrs, min;
    final int minPerHour = 60;
    hrs = minutes / minPerHour;
    min = minutes - (hrs * minPerHour);
    return String.format("%02d", hrs) + ":" + String.format("%02d", min);
  }
  
  public String preptimeFmt() {
    if (preptime != null) {
      return fmtTime(preptime);
    } else
      return "";
  }
  
  public void setPreptime(Integer preptime) {
    this.preptime = preptime;
  }
  
  public Integer getCooktime() {
    return cooktime;
  }
  
  public void setCooktime(Integer cooktime) {
    this.cooktime = cooktime;
  }
  
  public String cooktimeFmt() {
    if (cooktime != null) {
      return fmtTime(cooktime);
    } else
      return "";
  }
  
  public String getPortion() {
    return portion;
  }
  
  public void setPortion(String portion) {
    this.portion = portion;
  }
  
  public String getPortionuom() {
    return portionuom;
  }
  
  public void setPortionuom(String portionuom) {
    this.portionuom = portionuom;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getDescriptionbrief() {
    return descriptionbrief;
  }
  
  public void setDescriptionbrief(String descriptionbrief) {
    this.descriptionbrief = descriptionbrief;
  }
  
  public boolean isFeatured() {
    return featured;
  }
  
  public void setFeatured(boolean featured) {
    this.featured = featured;
  }
  
  public String getImage() {
    if (image == null || image.length() == 0 || image.trim().length() == 0) {
      return "/images/empty-plate.png";
    } else
      return image;
  }
  
  public void setImage(String image) {
    this.image = image;
  }
  
  public String getInstructions() {
    if (instructions == null || instructions.length() == 0) {
      return "";
    } else
      return instructions;
  }
  
  public String getInstructionsHTML() {
    return getInstructions();
  }
  
  public String toHTML(String text) {
    return text.replaceAll("\\n", "<br />\n");
  }
  
  public String instructionsHTML() {
    return toHTML(getInstructions());
  }
  
  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }
  
  public Date getVersiondate() {
    return versiondate;
  }
  
  public void setVersiondate(Date versiondate) {
    this.versiondate = versiondate;
  }
  
  @Override
  public String toString() {
    return title;
  }
}
