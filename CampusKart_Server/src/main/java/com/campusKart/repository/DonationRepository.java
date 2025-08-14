package com.campusKart.repository;

import com.campusKart.entity.DonationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<DonationRequest,Long> {
    Optional<DonationRequest> findById(Long id);
}
