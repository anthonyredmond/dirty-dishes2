package org.launchcode.DirtyDishesAndEmptyPlates.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe extends AbstractEntity{

    @NotNull
    @Size(min=3, max=64)
    private String title;
    private String version;
    private String author;
    private Integer serveqty;
    private String serveqtytype;
    private Integer preptime;
    private Integer cooktime;
    private String portion;
    private String description;
    private String descriptionbrief;
    private boolean featured;
    @Size(min=3, max=164)
    private String image;
    private String instructions;
    
    public Recipe() {
    }

    // Initialize the id and value fields.
    public Recipe(String aTitle, String anAuthor, Integer serves, String servedTo, Integer thePrepTime,
                  Integer theCookTime, String portionSize, String description, String briefdescription) {
        super();
        this.title = aTitle;
        this.author = anAuthor;
        this.description = description;
        this.serveqty = serves;
        this.serveqtytype = servedTo;
        this.preptime = thePrepTime;
        this.cooktime = theCookTime;
        this.portion = portionSize;
        this.description = description;
        this.descriptionbrief = descriptionbrief;
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

    public String getAuthor() {
        if (author != null) {
            return author;
        } else
            return "";
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getServeqty() {
        return serveqty;
    }

    public void setServeqty(Integer serveqty) {
        this.serveqty = serveqty;
    }

    public String getServeqtytype() {
        return serveqtytype;
    }

    public void setServeqtytype(String serveqtytype) {
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
            String out = String.valueOf(this.serveqty);
            if (serveqtytype != null)
                out += " " + serveqtytype.substring(0,1);
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
    
    public String toHTML(String text) {
        return text.replaceAll("\\n", "<br />\n");
    }
    
    public String instructionsHTML() {
        return toHTML(getInstructions());
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
