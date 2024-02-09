package com.example.a24pay.Home;

public class ListItem {
    private String title;
    private String subtitle;
    private int iconId;

    public ListItem(int iconId, String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
