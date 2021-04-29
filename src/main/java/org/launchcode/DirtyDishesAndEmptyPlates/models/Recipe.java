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

    public Recipe() {
    }

    // Initialize the id and value fields.
    public Recipe(String aTitle, String anAuthor, Integer serves, String servedTo, Integer thePrepTime, Integer theCookTime, String portionSize, String description) {
        super();
        this.title = aTitle;
        this.author = anAuthor;
        this.serveqty = serves;
        this.serveqtytype = servedTo;
        this.preptime = thePrepTime;
        this.cooktime = theCookTime;
        this.portion = portionSize;
        this.description = description;
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

    public Integer getPreptime() {
        return preptime;
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

    @Override
    public String toString() {
        return title;
    }
}
