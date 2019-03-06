package com.training.magang.ecommerce.product.controller;


import com.training.magang.ecommerce.product.model.Product;
import com.training.magang.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(
            value = "/products",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable("id") int id){
        return productService.findById(id);
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll(){

        return productService.findAll();
    }

    @RequestMapping(
            value = "/products",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product update(@RequestBody Product product){

        return productService.update(product);
    }

    @RequestMapping(
            value = "/products/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product delete(@PathVariable("id") int id){

        return productService.delete(id);
    }


}
