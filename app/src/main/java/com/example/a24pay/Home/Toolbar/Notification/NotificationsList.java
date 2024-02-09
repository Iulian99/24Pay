package com.example.a24pay.Home.Toolbar.Notification;

public class NotificationsList {

    private String title;
    private String text;
    private String publicationDate;
    private String link;

    public NotificationsList(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public NotificationsList(String publicationDate, String title, String text, String link) {
        this.publicationDate = publicationDate;
        this.title = title;
        this.text = text;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
