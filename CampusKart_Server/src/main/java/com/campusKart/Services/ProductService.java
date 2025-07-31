package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.auth.repository.UserRepo;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Product;
import com.campusKart.mapper.ProductMapper;
import com.campusKart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto, String email, MultipartFile file) throws IOException {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
        Product product = productMapper.toEntity(productRequestDto,file);
        product.setPostedBy(user);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
