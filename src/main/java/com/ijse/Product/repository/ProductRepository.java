package com.ijse.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.Product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
