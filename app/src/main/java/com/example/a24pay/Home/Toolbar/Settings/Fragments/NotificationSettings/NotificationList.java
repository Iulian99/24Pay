package com.example.a24pay.Home.Toolbar.Settings.Fragments.NotificationSettings;

public class NotificationList {
    private String title;
    private String text;

    private boolean isSwitchedOn;

    public NotificationList(String title, String text, boolean isSwitchedOn) {
        this.title = title;
        this.text = text;
        this.isSwitchedOn = isSwitchedOn;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
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
}
