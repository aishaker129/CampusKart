package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Enum.ProductStatus;
import com.campusKart.entity.Enum.RequestStatus;
import com.campusKart.entity.Product;
import com.campusKart.entity.ProductStatusChangedEvent;
import com.campusKart.entity.SwapRequest;
import com.campusKart.repository.ProductRepository;
import com.campusKart.repository.SwapRequestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SwapRequestService {
    private final SwapRequestRepository swapRequestRepository;
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public SwapRequest sendSwapRequest(Long productId, User requester,String offerItem) {
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));

        if(product.getStatus() != ProductStatus.AVAILABLE){
            throw new IllegalStateException("Product not available");
        }

        SwapRequest request = new SwapRequest();
        request.setProduct(product);
        request.setUser(requester);
        request.setOfferedItemDescription(offerItem);
        request.setRequestDate(LocalDateTime.now());
        request.setStatus(RequestStatus.PENDING);
        request.setAccepted(false);

        if(product.getStock() == 1){
            product.setStatus(ProductStatus.PENDING);
        }
        productRepository.save(product);
        SwapRequest saveData = swapRequestRepository.save(request);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,productId,product.getStatus(),product.getStatus())
        );

        return saveData;
    }

    @Transactional
    public void acceptSwapRequest(Long requestId) {
        SwapRequest swapRequest = swapRequestRepository.findById(requestId).orElseThrow(()->new RuntimeException("Request not found"));
        Product product = swapRequest.getProduct();
        if(product.getStatus() != ProductStatus.AVAILABLE){
            throw new IllegalStateException("Product not available");
        }

        if(product.getStock() == 1){
            product.setStatus(ProductStatus.SWAPPED);
        }
        product.setStatus(ProductStatus.AVAILABLE);
        swapRequest.setStatus(RequestStatus.ACCEPTED);
        swapRequest.setAccepted(true);
        productRepository.save(product);
        swapRequestRepository.save(swapRequest);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,requestId,product.getStatus(),product.getStatus())
        );
    }

    @Transactional
    public void rejectSwapRequest(Long requestId) {
        SwapRequest swapRequest =  swapRequestRepository.findById(requestId).orElseThrow(()->new RuntimeException("Request not found"));
        Product product = swapRequest.getProduct();
        if(product.getStatus() != ProductStatus.AVAILABLE){
            throw new IllegalStateException("Product not available");
        }

        swapRequest.setStatus(RequestStatus.REJECTED);
        swapRequest.setAccepted(false);
        if(product.getStatus() == ProductStatus.PENDING){
            product.setStatus(ProductStatus.AVAILABLE);
            productRepository.save(product);
        }
        swapRequestRepository.save(swapRequest);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,requestId,product.getStatus(),product.getStatus())
        );
    }
}
