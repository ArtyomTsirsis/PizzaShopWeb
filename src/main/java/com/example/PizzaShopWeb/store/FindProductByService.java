package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductName;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

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
        }
        ProductName productName = StreamSupport.stream(productRepository.findAll().spliterator(), false).
                filter(o -> o.getName().toString().equalsIgnoreCase(key)).
                map(converter::convertToDto).toList().get(0).getName();
        if (null != productName) {
            return findProductByNameService.findByName(productName);
        }
        return findAllProductsService.findAll();
    }

}
