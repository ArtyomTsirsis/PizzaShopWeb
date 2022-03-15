package com.example.PizzaShopWeb.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
@JsonPropertyOrder({"id", "name", "price", "qty"})
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @JsonProperty("ID")
//    @JsonIgnore
    private Long id;
    @Column
    @JsonProperty("Product")
    private ProductName name;
    @Column
    @JsonProperty("Price")
    private double price;
    @Column
    @JsonProperty("Quantity")
    private int qty;
    @Column
    @JsonIgnore
    private double markup;

    public Product(ProductName name, double price, double markup, int qty) {
        this.name = name;
        this.price = price;
        this.markup = markup;
        this.qty = qty;
    }

}
