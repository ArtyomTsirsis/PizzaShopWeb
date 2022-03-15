package com.example.PizzaShopWeb.dto;

import com.example.PizzaShopWeb.products.ProductName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDto {

    private Long id;
    private ProductName name;
    private double price;
    private int qty;
    private double markup;


}
