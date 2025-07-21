package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private Category category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImgUrl(this.getImage());
        product.setCategory(this.getCategory());
        return product;
    }

    public static GetProductResponseDto fromProduct(Product product) {
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setCategory(product.getCategory());
        getProductResponseDto.setImage(product.getImgUrl());
        return getProductResponseDto;
    }
}
