package com.example.demo.Repos;

import com.example.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Product, Long> {
    Product findByProductname(String productname);
}
