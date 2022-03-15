package com.example.PizzaShopWeb.dto;

import com.example.PizzaShopWeb.products.Product;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public ProductDto convertToDto(Product product) {
        return new ProductDto(product.getName(), product.getPrice(), product.getQty(), product.getMarkup());
    }

    public Product convertFromDto(ProductDto product) {
        return new Product(product.getName(), product.getPrice(), product.getQty(), product.getMarkup());
    }

}
