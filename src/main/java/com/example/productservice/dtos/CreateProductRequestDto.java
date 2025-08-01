package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {

    private String title;
    private String description;
    private double price;
    private String imgUrl;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setDescription(this.description);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setImgUrl(this.imgUrl);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);
        return product;
    }
}
