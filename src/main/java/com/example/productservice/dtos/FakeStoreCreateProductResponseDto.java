package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private String title;
    private Long id;
    private String description;
    private String image;
    private double price;
    private Category category;

}
