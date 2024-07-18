package com.ijse.Product.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.Product.entity.Product;
import com.ijse.Product.service.ProductService;

@RestController
public class ProductController {

@Autowired

private ProductService productService;

@PostMapping("/product")
public ResponseEntity<?> createProduct(@RequestBody Product product){

   if(product.getProductName()== null|| product.getProductName()==""){
    return ResponseEntity.status(400).body("Please Enter a Valid Name for the Product");
}
if(product.getDescription()==null) {
    return ResponseEntity.status(400).body("Please Enter the Description of the Product");
}
try{
    Product createProduct =productService.createProduct(product);
    return ResponseEntity.status(201).body(createProduct);
  }catch (Exception e){
      return ResponseEntity.status(400).body(e.getMessage());
}
  }

@GetMapping("/product")
public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> products =productService.getAllProducts();
    return ResponseEntity.status(200).body(products);
}   
@GetMapping("/product/{productId}")
public ResponseEntity<Product>getProductById(@PathVariable Long productId){
    Product product = productService.getProductById(productId);

    if(product== null){
        return ResponseEntity.status(401).body(null);
    } else{
        return ResponseEntity.status(200).body(product);
    }
}
@PutMapping("/product/{productId}")
public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product product){
   Product updatedProduct =productService.updateProduct(productId, product);

    if(updatedProduct==null){
        return ResponseEntity.status(404).body(null);
      }else{
        return ResponseEntity.status(200).body(product);
      }
}
@DeleteMapping("/product/{productId}")
public void deleteProduct(@PathVariable Long productId){
    productService.deleteProduct(productId);
}


}
