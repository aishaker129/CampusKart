package com.campusKart.Services;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Enum.ProductStatus;
import com.campusKart.entity.Enum.RequestStatus;
import com.campusKart.entity.Product;
import com.campusKart.entity.ProductStatusChangedEvent;
import com.campusKart.entity.PurchaseRequest;
import com.campusKart.repository.ProductRepository;
import com.campusKart.repository.PurchaseRequestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseRequestService {

    private final PurchaseRequestRepository purchaseRequestRepository;
    private  final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public PurchaseRequest sendPurchaseRequest(Long productId, User buyer){
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        if(product.getStatus() != ProductStatus.AVAILABLE){
            throw new IllegalStateException("Product is not available");
        }
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setBuyer(buyer);
        purchaseRequest.setProduct(product);

        product.setStatus(ProductStatus.PENDING);
        productRepository.save(product);

        PurchaseRequest update = purchaseRequestRepository.save(purchaseRequest);

        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,product.getId(),ProductStatus.AVAILABLE,ProductStatus.PENDING)
        );
        return update;
    }

    @Transactional
    public void acceptPurchaseRequest(Long requestId){
        PurchaseRequest purchaseRequest =  purchaseRequestRepository.findById(requestId).orElseThrow(()-> new RuntimeException("Request not found"));
        Product product = purchaseRequest.getProduct();

        product.setStatus(ProductStatus.SOLD);
        purchaseRequest.setStatus(RequestStatus.ACCEPTED);

        productRepository.save(product);
        purchaseRequestRepository.save(purchaseRequest);
        applicationEventPublisher.publishEvent(
                new ProductStatusChangedEvent(this,product.getId(),ProductStatus.PENDING,ProductStatus.SOLD)
        );
    }

}
