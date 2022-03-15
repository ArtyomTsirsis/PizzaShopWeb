package com.example.PizzaShopWeb.products;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Iterable<Product> findAllByPrice(double price);
    Iterable<Product> findAllByName(ProductName name);
    void deleteByName(ProductName name);

    @Modifying
    @Transactional
    @Query("UPDATE Product u SET price = :#{#p.price}, markup = :#{#p.markup}, qty = :#{#p.qty} WHERE name = :#{#p.name}")
    void updateProduct(@Param("p") Product product);

}
