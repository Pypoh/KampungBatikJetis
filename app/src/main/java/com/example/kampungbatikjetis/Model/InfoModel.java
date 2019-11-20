package com.example.kampungbatikjetis.Model;

public class InfoModel {

    private int imageID;
    private String infoTitle;

    public InfoModel(int imageID, String infoTitle) {
        this.imageID = imageID;
        this.infoTitle = infoTitle;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }
}
