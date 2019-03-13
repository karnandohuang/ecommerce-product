package com.training.magang.ecommerce.product.repository;

import com.training.magang.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
