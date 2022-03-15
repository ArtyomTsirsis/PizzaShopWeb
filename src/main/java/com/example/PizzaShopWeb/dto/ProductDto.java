package com.example.PizzaShopWeb.dto;

import com.example.PizzaShopWeb.products.ProductName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonPropertyOrder({"name", "price", "qty"})
public class ProductDto {

    @JsonProperty("Product")
    private ProductName name;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("Quantity")
    private int qty;
    @JsonIgnore
    private double markup;

}
