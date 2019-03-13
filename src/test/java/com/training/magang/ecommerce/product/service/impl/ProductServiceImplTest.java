package com.training.magang.ecommerce.product.service.impl;

import com.training.magang.ecommerce.product.model.Product;
import com.training.magang.ecommerce.product.repository.ProductRepository;
import com.training.magang.ecommerce.product.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testSave(){
        Product product = new Product();
        product.setName("Buku");
        product.setCategoryId(1);
        product.setPrice(10000);

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product result = productService.create(product);

        Assert.assertTrue(result.equals(product));
        Mockito.verify(productRepository, Mockito.times(1)).save(product);

    }

    @Test
    public void findByIdTest() {

        Product product = new Product();
        product.setId(1L);
        product.setName("Buku");
        product.setCategoryId(1);
        product.setPrice(10000);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());

        Assert.assertTrue(productService.findById(1L).equals(product));
        Assert.assertTrue(productService.findById(2L) == null);


    }

    @Test
    public void findAll() {

        Product product1 = new Product();
        product1.setName("Buku");
        product1.setCategoryId(1);
        product1.setPrice(10000);

        productService.create(product1);

        Product product2 = new Product();
        product2.setName("Pen");
        product2.setCategoryId(2);
        product2.setPrice(5000);

        productService.create(product2);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        Assert.assertEquals(productService.findAll(), productList);

    }

    @Test
    public void update() {

        Product product1 = new Product();
        product1.setName("Buku");
        product1.setCategoryId(1);
        product1.setPrice(10000);

        productService.create(product1);

        Product product2 = new Product();
        product2.setId(1L);
        product2.setName("Pen");
        product2.setCategoryId(2);
        product2.setPrice(5000);

        productService.update(product2);

        Assert.assertEquals(productService.findById(1L), product2);
    }

    @Test
    public void delete() {
        Product product1 = new Product();
        product1.setName("Buku");
        product1.setCategoryId(1);
        product1.setPrice(10000);

        productService.create(product1);

        productService.delete(1L);

        Assert.assertTrue(productService.findAll().size() == 0);


    }
}