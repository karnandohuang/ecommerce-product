package com.training.magang.ecommerce.product.service.impl;

import com.training.magang.ecommerce.product.model.Product;
import com.training.magang.ecommerce.product.repository.ProductRepository;
import com.training.magang.ecommerce.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {

        productRepository.save(product);

        return product;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Product productData = findById(product.getId());
        if (productData != null) {
            BeanUtils.copyProperties(productData, product);
            productRepository.save(productData);
            return productData;
        }

        return null;
    }

    @Override
    public Product delete(Long id) {

        Product product = findById(id);

        productRepository.delete(product);

        return product;
    }
}
