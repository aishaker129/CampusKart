package com.campusKart.mapper;

import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setCondition(productRequestDto.getCondition());
        product.setProductCategory(productRequestDto.getProductCategory());
        product.setProductType(productRequestDto.getProductType());
        product.setCreatedAt(LocalDateTime.now());
        return product;
    }
    public ProductResponseDto toDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setCondition(product.getCondition());
        productResponseDto.setProductCategory(product.getProductCategory());
        productResponseDto.setProductType(product.getProductType());
        productResponseDto.setCreatedAt(product.getCreatedAt());
        productResponseDto.setPostedBy(product.getPostedBy().getEmail());

        return productResponseDto;
    }

}
