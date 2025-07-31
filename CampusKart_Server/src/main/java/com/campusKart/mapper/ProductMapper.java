package com.campusKart.mapper;

import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Product;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductMapper {
    private  Cloudinary cloudinary;

    public ProductMapper(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public Product toEntity(ProductRequestDto productRequestDto, MultipartFile file) throws IOException {
        Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder","productImage"));
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setCondition(productRequestDto.getCondition());
        product.setProductCategory(productRequestDto.getProductCategory());
        product.setProductType(productRequestDto.getProductType());
        product.setCreatedAt(LocalDateTime.now());
        product.setImageUrl(uploadedFile.get("secure_url").toString());
        product.setImagePublicId(uploadedFile.get("public_id").toString());
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
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setProductType(product.getProductType());
        productResponseDto.setCreatedAt(product.getCreatedAt());
        productResponseDto.setPostedBy(product.getPostedBy().getEmail());

        return productResponseDto;
    }

}
