package com.campusKart.dto;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Enum.ProductCategory;
import com.campusKart.entity.Enum.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String imagePublicId;
    private boolean sold;
    private String condition;
    private ProductCategory productCategory;
    private ProductType productType;
    private LocalDateTime createdAt;
    private User postedBy;
}
