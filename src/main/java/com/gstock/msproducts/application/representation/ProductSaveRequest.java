package com.gstock.msproducts.application.representation;

import com.gstock.msproducts.domain.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSaveRequest {
    private String name;
    private BigDecimal price;
    private String sku;

    public Product toModel(){
        return new Product(name, price, sku);
    }
}
