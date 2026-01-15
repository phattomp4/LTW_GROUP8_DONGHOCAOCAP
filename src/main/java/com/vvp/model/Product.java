package com.vvp.model;

public class Product {
    private int id;
    private int brandId;
    private String name;
    private String sku;
    private String description;
    private double originalPrice;
    private double currentPrice;
    private String imageUrl;
    private int stockQuantity;
    private int soldQuantity;

    public Product() {}

    public Product(int id, int brandId, String name, String sku, String description, double originalPrice, double currentPrice, String imageUrl, int stockQuantity, int soldQuantity) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        this.imageUrl = imageUrl;
        this.stockQuantity = stockQuantity;
        this.soldQuantity = soldQuantity;
    }



    // Getter methods (Cực kỳ quan trọng để JSP đọc được)
    public int getId() { return id; }
    public int getBrandId() { return brandId; }
    public String getName() { return name; }
    public String getSku() { return sku; }
    public String getDescription(){return description;}
    public double getOriginalPrice() { return originalPrice; }
    public double getCurrentPrice() { return currentPrice; }
    public String getImageUrl() { return imageUrl; }
    public int getStockQuantity(){return stockQuantity;}
    public int getSoldQuantity() { return soldQuantity; }
}