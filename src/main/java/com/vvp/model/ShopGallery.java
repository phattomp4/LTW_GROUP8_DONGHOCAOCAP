package com.vvp.model;

public class ShopGallery {
    private int imageID;
    private String imageUrl;

    // 1. Constructor không tham số
    public ShopGallery() {
    }

    // 2. Constructor đầy đủ tham số
    public ShopGallery(int imageID, String imageUrl) {
        this.imageID = imageID;
        this.imageUrl = imageUrl;
    }

    // 3. Getter và Setter
    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}