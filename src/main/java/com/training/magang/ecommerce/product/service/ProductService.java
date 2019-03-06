package com.training.magang.ecommerce.product.service;

import com.training.magang.ecommerce.product.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product findById(int id);
    List<Product> findAll();
    Product update(Product product);
    Product delete(int id);

}
