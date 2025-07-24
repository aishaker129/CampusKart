package com.campusKart.repository;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPostedBy(User user);
    List<Product> findByPostedByAndSold(User user,boolean sold);
}
