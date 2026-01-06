package com.vvp.model;

public class CartItem extends Product {
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product p, int quantity) {
        // Bây giờ bạn có thể dùng p.getDescription() và p.getStockQuantity() mà không bị lỗi
        super(p.getId(), p.getBrandId(), p.getName(), p.getSku(), p.getDescription(), p.getOriginalPrice(), p.getCurrentPrice(), p.getImageUrl(), p.getStockQuantity(), p.getSoldQuantity());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.getCurrentPrice() * quantity;
    }
}