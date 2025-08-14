package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.DonationRequest;
import com.campusKart.entity.Enum.ProductStatus;
import com.campusKart.entity.Enum.RequestStatus;
import com.campusKart.entity.Product;
import com.campusKart.entity.ProductStatusChangedEvent;
import com.campusKart.repository.DonationRepository;
import com.campusKart.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public DonationRequest seendDonationRequest(Long productId, User requester, int quantity){
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));

        if(product.getStatus() != ProductStatus.AVAILABLE){
            throw new IllegalStateException("Product not available");
        }

        if(quantity <= 0){
            throw new IllegalStateException("Quantity must be greater than 0");
        }
        if(quantity > product.getStock()){
            throw new IllegalStateException("Quantity must be less than stock");
        }

        DonationRequest donationRequest = new DonationRequest();
        donationRequest.setRequester(requester);
        donationRequest.setProduct(product);
        donationRequest.setProductQuantity(quantity);

        product.setStatus(ProductStatus.PENDING);
        productRepository.save(product);
        DonationRequest donate = donationRepository.save(donationRequest);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,productId,ProductStatus.AVAILABLE,ProductStatus.PENDING)
        );

        return donate;

    }

    @Transactional
    public void acceptDonationRequest(Long requestId){
        DonationRequest donateRequest = donationRepository.findById(requestId).orElseThrow(()-> new RuntimeException("DonationRequest not found"));
        Product product = donateRequest.getProduct();
        int quantity = product.getStock() - donateRequest.getProductQuantity();
        if(quantity <= 0){
            throw new IllegalStateException("Not enough stock to fulfill donation");
        }

        product.setStock(quantity);

        if(quantity == 0){
            product.setStatus(ProductStatus.DONATED);
        }
        else{
            product.setStatus(ProductStatus.AVAILABLE);
        }

        donateRequest.setRequestStatus(RequestStatus.ACCEPTED);
        productRepository.save(product);
        donationRepository.save(donateRequest);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,product.getId(),ProductStatus.AVAILABLE,ProductStatus.DONATED)
        );
    }
}
