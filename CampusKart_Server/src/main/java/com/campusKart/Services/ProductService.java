package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.auth.repository.UserRepo;
import com.campusKart.dto.ProductRequestDto;
import com.campusKart.dto.ProductResponseDto;
import com.campusKart.entity.Product;
import com.campusKart.mapper.ProductMapper;
import com.campusKart.repository.ProductRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private UserRepo userRepo;
    private Cloudinary cloudinary;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper, UserRepo userRepo, Cloudinary cloudinary) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepo = userRepo;
        this.cloudinary = cloudinary;
    }

    public List<ProductResponseDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto, String email, MultipartFile file) throws IOException {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
        Product product = productMapper.toEntity(productRequestDto,file);
        product.setPostedBy(user);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public ProductResponseDto getProductById(Long id) throws IOException {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    public List<ProductResponseDto> getProductByUser(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
        return productRepository.findByPostedBy(user).stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public ProductResponseDto updateProductById(Long productId, ProductRequestDto productRequestDto,MultipartFile file) throws IOException {
        Product currentProduct = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));

        if(currentProduct.getImagePublicId() != null){
            cloudinary.uploader().destroy(currentProduct.getImagePublicId(), ObjectUtils.emptyMap());
        }

        Map upload = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.asMap("folder","productImage"));
        currentProduct.setTitle(productRequestDto.getTitle());
        currentProduct.setDescription(productRequestDto.getDescription());
        currentProduct.setPrice(productRequestDto.getPrice());
        currentProduct.setProductCategory(productRequestDto.getProductCategory());
        currentProduct.setProductType(productRequestDto.getProductType());
        currentProduct.setCondition(productRequestDto.getCondition());
        currentProduct.setImageUrl(upload.get("secure_url").toString());
        currentProduct.setImagePublicId(upload.get("public_id").toString());
        productRepository.save(currentProduct);
        return productMapper.toDto(currentProduct);
    }

    public String deleteProductById(Long productId) throws IOException {
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        if(product.getImagePublicId() != null){
            cloudinary.uploader().destroy(product.getImagePublicId(),ObjectUtils.emptyMap());
        }

        productRepository.delete(product);

        return "Product deleted successfully";
    }

    public List<ProductResponseDto> getProductByPriceRange(Double min, Double max) {
        List<Product> products = productRepository.findByPriceBetween(min,max);
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public List<ProductResponseDto> getProductByKeyword(String keyword) {
        List<Product> products = productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword,keyword);
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public Page<ProductResponseDto> getProducts(int page,int size,String sort,String direction) {
        Sort sortBy = direction.equalsIgnoreCase("desc")
                ? Sort.by(sort).descending()
                : Sort.by(sort).ascending();

        Pageable pageable = PageRequest.of(page, size, sortBy);
        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.map(productMapper::toDto);
    }

}
