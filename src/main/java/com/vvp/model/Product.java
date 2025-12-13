package com.vvp.model;

public class Product {
    private int id;
    private int brandId;
    private String name;
    private String sku;
    private double originalPrice;
    private double currentPrice;
    private String imageUrl;
    private int soldQuantity;

    public Product() {}

    public Product(int id, int brandId, String name, String sku, double originalPrice, double currentPrice, String imageUrl, int soldQuantity) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.sku = sku;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        this.imageUrl = imageUrl;
        this.soldQuantity = soldQuantity;
    }

    public Product(int productID, int brandID, String name, String sku, String description, double originalPrice, double currentPrice, String imageURL, int stockQuantity, int soldQuantity) {
    }

    // Getter methods (Cực kỳ quan trọng để JSP đọc được)
    public int getId() { return id; }
    public int getBrandId() { return brandId; }
    public String getName() { return name; }
    public String getSku() { return sku; }
    public double getOriginalPrice() { return originalPrice; }
    public double getCurrentPrice() { return currentPrice; }
    public String getImageUrl() { return imageUrl; }
    public int getSoldQuantity() { return soldQuantity; }
}