package com.campusKart.controller;

import com.campusKart.Services.DonationService;
import com.campusKart.auth.entity.User;
import com.campusKart.entity.DonationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions/donation")
@RequiredArgsConstructor
public class DonationTransactionController {

    private final DonationService donationService;

    @PostMapping("/{productId}")
    private ResponseEntity<DonationRequest> sendRequest(@PathVariable Long productId,@RequestBody int quantity, Authentication authentication){
        User requester = (User) authentication.getPrincipal();
        return ResponseEntity.ok(
                donationService.seendDonationRequest(productId,requester,quantity)
        );
    }

    @PostMapping("/accept/{requestId}")
    private ResponseEntity<?> acceptRequest(@PathVariable Long requestId){
        donationService.acceptDonationRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
