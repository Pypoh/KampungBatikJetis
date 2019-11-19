package com.example.kampungbatikjetis.Model;

public class LayananModel {
    private int imageID;
    private String textTitle;
    private String textDesc;

    public LayananModel(int imageID, String textTitle, String textDesc) {
        this.imageID = imageID;
        this.textTitle = textTitle;
        this.textDesc = textDesc;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDesc() {
        return textDesc;
    }

    public void setTextDesc(String textDesc) {
        this.textDesc = textDesc;
    }
}
