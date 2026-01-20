package com.vvp.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Tính tổng tiền = giá * số lượng
    public double getTotalPrice() {
        // Sửa getPrice() thành getCurrentPrice()
        return product.getCurrentPrice() * quantity;
    }
}