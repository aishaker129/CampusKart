package com.campusKart.controller;

import com.campusKart.Services.PurchaseRequestService;
import com.campusKart.auth.entity.User;
import com.campusKart.entity.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions/purchase")
@RequiredArgsConstructor
public class PurchaseTransactionController {

    private final PurchaseRequestService purchaseRequestService;

    @PostMapping("/{productId}")
    public ResponseEntity<PurchaseRequest> sendRequest(@PathVariable Long productId, Authentication auth){
        User buyer = (User) auth.getPrincipal();
        return ResponseEntity.ok(purchaseRequestService.sendPurchaseRequest(productId,buyer));
    }

    @PostMapping("/accept/{requestId}")
    public ResponseEntity<PurchaseRequest> acceptRequest(@PathVariable Long requestId){
        purchaseRequestService.acceptPurchaseRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
