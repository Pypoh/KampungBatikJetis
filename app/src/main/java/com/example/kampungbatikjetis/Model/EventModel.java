package com.example.kampungbatikjetis.Model;

public class EventModel {

    private int imageID;
    private String eventTitle;
    private String eventDate;
    private String eventDescription;

    public EventModel(int imageID, String eventTitle, String eventDate, String eventDescription) {
        this.imageID = imageID;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
