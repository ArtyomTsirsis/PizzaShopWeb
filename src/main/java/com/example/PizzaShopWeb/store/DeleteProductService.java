package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Comparator;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class DeleteProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Comparator comparator;

    public void delete(ProductDto product) {
        if (comparator.compare(product)) {
            productRepository.deleteByName(product.getName());
        }
    }

}
