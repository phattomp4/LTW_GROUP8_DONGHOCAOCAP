package com.vvp.model;

public class Product {
    private int id;
    private int brandId;
    private String name;
    private String sku;
    private String description; // 1. Thêm thuộc tính này
    private double originalPrice;
    private double currentPrice;
    private String imageUrl;
    private int stockQuantity;  // 2. Thêm thuộc tính này
    private int soldQuantity;

    public Product() {}

    public Product(int id, int brandId, String name, String sku, String description, double originalPrice, double currentPrice, String imageUrl, int stockQuantity, int soldQuantity) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.sku = sku;
        this.description = description; // 3. Gán giá trị description
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        this.imageUrl = imageUrl;
        this.stockQuantity = stockQuantity; // 4. Gán giá trị stockQuantity
        this.soldQuantity = soldQuantity;
    }

    // Getter methods
    public int getId() { return id; }
    public int getBrandId() { return brandId; }
    public String getName() { return name; }
    public String getSku() { return sku; }
    public String getDescription() { return description; } // 5. Thêm getter
    public double getOriginalPrice() { return originalPrice; }
    public double getCurrentPrice() { return currentPrice; }
    public String getImageUrl() { return imageUrl; }
    public int getStockQuantity() { return stockQuantity; } // 6. Thêm getter
    public int getSoldQuantity() { return soldQuantity; }

    // Setter methods (Nên có để linh hoạt)
    public void setId(int id) { this.id = id; }
    public void setBrandId(int brandId) { this.brandId = brandId; }
    public void setName(String name) { this.name = name; }
    public void setSku(String sku) { this.sku = sku; }
    public void setDescription(String description) { this.description = description; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }
    public void setCurrentPrice(double currentPrice) { this.currentPrice = currentPrice; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public void setSoldQuantity(int soldQuantity) { this.soldQuantity = soldQuantity; }
}