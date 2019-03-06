package com.training.magang.ecommerce.product.service.impl;

import com.training.magang.ecommerce.product.model.Product;
import com.training.magang.ecommerce.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public Product create(Product product) {

        products.add(product);

        return product;
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product update(Product newProduct) {

        Product product1 = findById(newProduct.getId());

        if(product1 == null)
            return null;

        for (Product product : products ) {

            if(newProduct.getId() == product.getId()){
                BeanUtils.copyProperties(product, newProduct);

                return product;
            }
        }

        return null;
    }

    @Override
    public Product delete(int id) {
        Product product = findById(id);

        if(product == null)
            return null;

        products.remove(findById(id));

        return null;
    }
}
