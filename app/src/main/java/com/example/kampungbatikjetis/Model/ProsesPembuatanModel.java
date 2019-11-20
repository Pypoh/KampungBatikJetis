package com.example.kampungbatikjetis.Model;

public class ProsesPembuatanModel {
    private int imageID;
    private String description;

    public ProsesPembuatanModel(int imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
