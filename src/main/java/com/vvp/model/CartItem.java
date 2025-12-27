package com.vvp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Product product; // Đảm bảo bạn đã có class Product
    private int quantity;

    // Hàm tính thành tiền của item này
    public double getTotalPrice() {
        return product.getCurrentPrice() * quantity;
    }
}