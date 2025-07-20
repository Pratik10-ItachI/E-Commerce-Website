package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsResponseDto {
    List<GetProductResponseDto> listProductResponseDto;
}
