package org.sid.billingproducer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductItem {
    private Long id;
    private double quantity;
    private double price;
    private String productId;

    private Bill bill;

    public double getAmount()
    {
        return price * quantity;
    }
}
