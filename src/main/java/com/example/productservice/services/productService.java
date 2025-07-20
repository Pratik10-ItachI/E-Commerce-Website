package com.example.productservice.services;

import com.example.productservice.Exceptions.ResourceNotFoundException;
import com.example.productservice.models.Product;
import java.util.List;

public interface productService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProduct(Long id) throws ResourceNotFoundException;
}
