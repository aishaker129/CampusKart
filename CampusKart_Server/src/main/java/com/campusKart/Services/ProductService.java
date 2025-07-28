package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.auth.repository.UserRepo;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Enum.ProductCategory;
import com.campusKart.entity.Enum.ProductType;
import com.campusKart.entity.Product;
import com.campusKart.mapper.ProductMapper;
import com.campusKart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private UserRepo userRepo;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper, UserRepo userRepo) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepo = userRepo;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto, String email) {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
        Product product = productMapper.toEntity(productRequestDto);
        product.setPostedBy(user);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
