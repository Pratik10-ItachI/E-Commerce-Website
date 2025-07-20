package com.example.productservice.controllers;

import com.example.productservice.Exceptions.ResourceNotFoundException;
import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.CreateProductResponseDto;
import com.example.productservice.dtos.GetAllProductsResponseDto;
import com.example.productservice.dtos.GetProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.productService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    private final productService productService;

    public productController(productService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {

        Product product = productService.createProduct(createProductRequestDto.toProduct());

        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts() {

        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto getAllProductsResponseDto = new GetAllProductsResponseDto();
        List<GetProductResponseDto> listgetProductResponseDto = new ArrayList<>();
        for (Product product : products) {
            GetProductResponseDto getProductResponseDto = GetProductResponseDto.fromProduct(product);
            listgetProductResponseDto.add(getProductResponseDto);
        }
        getAllProductsResponseDto.setListProductResponseDto(listgetProductResponseDto);
        return getAllProductsResponseDto;
    }

    @GetMapping("/{id}")
    public CreateProductResponseDto getSingleProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {

        Product product = productService.getProduct(id);
        return CreateProductResponseDto.fromProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

        productService.deleteProduct(id);
    }
}
