package com.example.a24pay.Services;

public class ImageTitleList {
    public static final int TEXT_TYPE = 0;
    public static final int IMAGE_TYPE = 1;
    private int idImage;
    private String imageTitles;
    private int type;
    private String transportTypeTextView;

    public ImageTitleList(int idImage, String imageTitles, int type,String transportTypeTextView) {
        this.idImage = idImage;
        this.imageTitles = imageTitles;
        this.type = type;
        this.transportTypeTextView = transportTypeTextView;
    }

    public ImageTitleList(int idImage, String imageTitles, int type) {
        this.idImage = idImage;
        this.imageTitles = imageTitles;
        this.type = type;
    }

    public ImageTitleList(String imageTitles) {
        this.imageTitles = imageTitles;
    }

    public String getTransportTypeTextView() {
        return transportTypeTextView;
    }

    public void setTransportTypeTextView(String transportTypeTextView) {
        this.transportTypeTextView = transportTypeTextView;
    }

    public int getImage() {
        return idImage;
    }

    public void setImage(int idImage) {
        this.idImage = idImage;
    }

    public String getTitles() {
        return imageTitles;
    }

    public void setTitles(String imageTitles) {
        this.imageTitles = imageTitles;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return transportTypeTextView;
    }
}
