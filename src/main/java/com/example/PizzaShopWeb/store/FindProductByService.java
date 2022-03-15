package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductName;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FindProductByService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Converter converter;
    @Autowired
    private FindAllProductsService findAllProductsService;
    @Autowired
    private FindProductByNameService findProductByNameService;
    @Autowired
    private FindProductByPriceService findProductByPriceService;


    public List<ProductDto> findBy(String key) {
        if (key.matches("\\d") || key.matches("\\d.\\d")) {
            return findProductByPriceService.findByPrice(Double.parseDouble(key));
        } else if (Arrays.stream(ProductName.values()).anyMatch(n -> n.toString().equalsIgnoreCase(key))) {
            return findProductByNameService.findByName(ProductName.valueOf(key));
        } else {
            return findAllProductsService.findAll();
        }
    }

}
