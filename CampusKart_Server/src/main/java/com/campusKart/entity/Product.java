package com.campusKart.entity;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Enum.ProductCategory;
import com.campusKart.entity.Enum.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String imagePublicId;
    private boolean sold;
    private String condition;
    private String stock;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    private ProductType productType; // sele, rent,swap and donate

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User postedBy;

//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<SwapRequest> swapRequests;
}
