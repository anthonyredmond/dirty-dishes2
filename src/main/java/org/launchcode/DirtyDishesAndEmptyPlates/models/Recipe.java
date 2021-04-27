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
    private Integer serveQty;
    private String serveQtyType;
    private Integer prepTime;
    private Integer cookTime;
    private String portion;

    public Recipe() {
    }

    // Initialize the id and value fields.
    public Recipe(String aTitle, String anAuthor, Integer serves, String servedTo, Integer thePrepTime, Integer theCookTime, String portionSize) {
        super();
        this.title = aTitle;
        this.author = anAuthor;
        this.serveQty = serves;
        this.serveQtyType = servedTo;
        this.prepTime = thePrepTime;
        this.cookTime = theCookTime;
        this.portion = portionSize;
    }

    // Getters and setters.
    public String getTitle() {
        return title;
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
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getServeQty() {
        return serveQty;
    }

    public void setServeQty(Integer serveQty) {
        this.serveQty = serveQty;
    }

    public String getServeQtyType() {
        return serveQtyType;
    }

    public void setServeQtyType(String serveQtyType) {
        this.serveQtyType = serveQtyType;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return title;
    }
}
