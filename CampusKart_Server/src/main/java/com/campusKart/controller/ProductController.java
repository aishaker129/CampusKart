package com.campusKart.controller;

import com.campusKart.Services.ProductService;
import com.campusKart.auth.service.AuthService;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;
    private ObjectMapper objectMapper;

    public ProductController(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAll() {
        List<ProductResponseDto> productResponseDto = productService.findAll();
        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestParam("product") String ProductJson, @RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        ProductRequestDto productDto = objectMapper.readValue(ProductJson, ProductRequestDto.class);
       return ResponseEntity.ok(productService.createProduct(productDto,principal.getName(),file));
    }
}

