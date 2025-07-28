package com.campusKart.controller;

import com.campusKart.Services.ProductService;
import com.campusKart.auth.service.AuthService;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto, Principal principal) {
       return ResponseEntity.ok(productService.createProduct(productRequestDto,principal.getName()));
    }
}

