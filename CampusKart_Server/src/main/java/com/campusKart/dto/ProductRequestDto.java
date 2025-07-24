package com.campusKart.dto;

import com.campusKart.entity.Enum.ProductCategory;
import com.campusKart.entity.Enum.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String condition;
    private ProductCategory productCategory;
    private ProductType productType;
}
