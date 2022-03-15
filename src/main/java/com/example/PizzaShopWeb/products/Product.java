package com.example.PizzaShopWeb.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private ProductName name;
    @Column
    private double price;
    @Column
    private int qty;
    @Column
    private double markup;

    public Product(ProductName name, double price, int qty, double markup) {
        this.name = name;
        this.price = price;
        this.markup = markup;
        this.qty = qty;
    }

}
