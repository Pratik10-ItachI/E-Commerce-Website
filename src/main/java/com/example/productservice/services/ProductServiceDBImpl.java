package com.example.productservice.services;

import com.example.productservice.Exceptions.ResourceNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceDBImpl implements productService{

    private ProductRepository productRepository ;
    private CategoryRepository categoryRepository ;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {

        product.setCategory(getCategoryToBeInProduct(product));
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }
        else{
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product, Long id) throws ResourceNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ResourceNotFoundException("Product with id: " + id + " not found");
        }

        product.setCategory(getCategoryToBeInProduct(product));
        product.setId(id);
        return productRepository.save(product);

    }

    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category toBeInProduct;
        if(category.isEmpty()){
            toBeInProduct = categoryRepository.save(product.getCategory());
        }
        else{
            toBeInProduct = category.get();
        }
        return toBeInProduct;
    }
}
