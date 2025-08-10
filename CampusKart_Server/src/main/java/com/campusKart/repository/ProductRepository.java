package com.campusKart.repository;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPostedBy(User user);
    Optional<Product> findById(Long id);
    List<Product> findByPriceBetween(Double min, Double max);
    List<Product> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
    Page<Product> findAll(Pageable pageable);

    Page<Product> findByProductCategoryContainingIgnoreCaseOrProductTypeContainingIgnoreCaseOrConditionContainingIgnoreCase(
            String category, String type, String condition, Pageable pageable
    );
}
