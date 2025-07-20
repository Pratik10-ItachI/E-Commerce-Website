package com.example.productservice.dtos;

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
    private String category;

}
