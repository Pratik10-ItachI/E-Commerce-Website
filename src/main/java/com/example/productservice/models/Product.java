package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseClass{

    private String title;
    private String description;
    private double price;
    private String imgUrl;
    @ManyToOne
    private Category category;
}
