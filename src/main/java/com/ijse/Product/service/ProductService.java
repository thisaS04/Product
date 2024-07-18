package com.ijse.Product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.Product.entity.Product;


@Service
public interface ProductService {

        Product createProduct(Product product);
        List<Product> getAllProducts();
        Product getProductById(Long id);
        Product updateProduct(Long id, Product product);
        void deleteProduct(Long id);
       
    
}
