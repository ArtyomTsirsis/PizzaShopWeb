package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.Product;
import com.example.PizzaShopWeb.products.ProductRepository;
import com.example.PizzaShopWeb.utils.ListAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class FindProductByService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FindAllProductsService findAllProductsService;
    @Autowired
    private FindProductByNameService findProductByNameService;
    @Autowired
    private FindProductByPriceService findProductByPriceService;
    @Autowired
    private FindProductByIdService findProductByIdService;
    @Autowired
    private ListAssembler listAssembler;

    public List<ProductDto> findBy(String key) {
        if (key.matches("\\d") || key.matches("\\d.\\d")) {
            return listAssembler.assemble
                    (findProductByPriceService.find(Double.parseDouble(key)),
                            findProductByIdService.find(Long.parseLong(key)));
        }
        List<Product> products = StreamSupport.stream(productRepository.findAll().spliterator(), false).
                filter(o -> o.getName().toString().equalsIgnoreCase(key)).toList();
        if (!products.isEmpty()) {
            return findProductByNameService.find(products.get(0).getName());
        }
        return findAllProductsService.find();
    }

}
