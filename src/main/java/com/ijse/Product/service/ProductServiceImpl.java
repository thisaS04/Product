package com.ijse.Product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.Product.entity.Product;
import com.ijse.Product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
@Autowired
  private ProductRepository productRepository;


@Override
public Product createProduct(Product product){
    return productRepository.save(product);
}
@Override
public List<Product> getAllProducts(){
    return productRepository.findAll();
}
@Override
public Product getProductById(Long id){
   return productRepository.findById(id).orElse(null);
}
@Override
public Product updateProduct(Long id, Product product){
   Product existingProduct = productRepository.findById(id).orElse(null);

   if(existingProduct == null){
      return null;
   }else{
    existingProduct.setProductName(product.getProductName());
    existingProduct.setDescription(product.getDescription());
    existingProduct.setPrice(product.getPrice());
      return productRepository.save(existingProduct);
   }
}
@Override
public void deleteProduct(Long id){
   productRepository.deleteById(id);

}

}
