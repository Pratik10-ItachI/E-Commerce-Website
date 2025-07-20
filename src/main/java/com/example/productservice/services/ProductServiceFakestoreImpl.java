package com.example.productservice.services;

import com.example.productservice.Exceptions.ResourceNotFoundException;
import com.example.productservice.dtos.*;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ProductServiceFakestoreImpl implements productService {

    private final RestTemplate restTemplate;

    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product){
        FakeStoreCreateProductRequestDto request=new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setImage(product.getImgUrl());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        request.setTitle(product.getTitle());

        FakeStoreCreateProductResponseDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class);

        Product product1=new Product();
        product1.setDescription(responseDto.getDescription());
        product1.setTitle(responseDto.getTitle());
        product1.setPrice(responseDto.getPrice());
        product1.setCategoryName(responseDto.getCategory());
        product1.setImgUrl(responseDto.getImage());
        product1.setId(responseDto.getId());

        return product1;
    }

    @Override
    public List<Product> getAllProducts(){

        GetProductResponseDto[] listGetProductResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products",
                GetProductResponseDto[].class);

        List<Product> allProducts = new ArrayList<Product>();

        for(GetProductResponseDto getProductResponseDto:listGetProductResponseDto){
            allProducts.add(getProductResponseDto.toProduct());
        }

        return allProducts;
    }

    public Product getProduct(Long id) throws ResourceNotFoundException {

        GetProductResponseDto request= restTemplate.getForObject("https://fakestoreapi.com/products/"+id.toString(),
                GetProductResponseDto.class);

        if(request==null){
            throw new ResourceNotFoundException();
        }

        return request.toProduct();
    }
}
