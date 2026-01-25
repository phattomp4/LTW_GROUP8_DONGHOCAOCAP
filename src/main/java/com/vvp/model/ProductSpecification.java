package com.vvp.model;

public class ProductSpecification {
    private int id;
    private int productId;
    private String name;
    private String value;

    public ProductSpecification() {}

    public ProductSpecification(int id, int productId, String name, String value) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.value = value;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}