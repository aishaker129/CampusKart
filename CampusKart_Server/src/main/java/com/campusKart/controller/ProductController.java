package com.campusKart.controller;

import com.campusKart.Services.ProductService;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;
    private ObjectMapper objectMapper;

    public ProductController(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProduct() {
        List<ProductResponseDto> productResponseDto = productService.findAllProducts();
        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestParam("product") String ProductJson, @RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        ProductRequestDto productDto = objectMapper.readValue(ProductJson, ProductRequestDto.class);
       return ResponseEntity.ok(productService.createProduct(productDto,principal.getName(),file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) throws IOException {
        ProductResponseDto productResponseDto = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping("/my-product")
    public ResponseEntity<List<ProductResponseDto>> getProductByUser(Authentication authentication) throws IOException {
        String email = authentication.getName();
        return ResponseEntity.ok(productService.getProductByUser(email));
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestParam("product") String ProductJson,@RequestParam("image") MultipartFile file) throws IOException {
        ProductRequestDto productDto = objectMapper.readValue(ProductJson, ProductRequestDto.class);
        return ResponseEntity.ok(productService.updateProductById(id,productDto,file));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<ProductResponseDto>> getPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(productService.getProductByPriceRange(min,max));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDto>> getProductBySearch(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.getProductByKeyword(keyword));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductResponseDto>> getAllProductsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        return ResponseEntity.ok(productService.getProducts(page,size,sortBy,direction));
    }

}

