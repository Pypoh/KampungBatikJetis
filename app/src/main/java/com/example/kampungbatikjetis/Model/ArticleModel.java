package com.example.kampungbatikjetis.Model;

public class ArticleModel {
    private String imageId;
    private String title;
    private String date;
    private String description;

    public ArticleModel(String imageId, String title, String date, String description) {
        this.imageId = imageId;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public ArticleModel() {

    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
