package com.example.kampungbatikjetis.Model;

public class PenghargaanModel {

    private String imageId;
    private String textTitle;
    private String textDate;
    private String textDescription;

    public PenghargaanModel() {
    }

    public PenghargaanModel(String imageId, String textTitle, String textDate, String textDescription) {
        this.imageId = imageId;
        this.textTitle = textTitle;
        this.textDate = textDate;
        this.textDescription = textDescription;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDate() {
        return textDate;
    }

    public void setTextDate(String textDate) {
        this.textDate = textDate;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }
}
