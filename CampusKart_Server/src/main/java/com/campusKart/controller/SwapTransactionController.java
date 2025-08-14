package com.campusKart.controller;

import com.campusKart.Services.SwapRequestService;
import com.campusKart.auth.entity.User;
import com.campusKart.entity.SwapRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions/swap")
@RequiredArgsConstructor
public class SwapTransactionController {

    private final SwapRequestService swapRequestService;

    @PostMapping("/{productId}")
    public ResponseEntity<SwapRequest> sendRequest(@PathVariable Long productId, @RequestParam String offerItem, Authentication authentication) {
        User requester = (User) authentication.getPrincipal();
        return ResponseEntity.ok(swapRequestService.sendSwapRequest(productId,requester,offerItem));
    }

    @PostMapping("/accept/{requestId}")
    public ResponseEntity<?> acceptRequest(@PathVariable Long requestId) {
        swapRequestService.acceptSwapRequest(requestId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject/{requestId}")
    public ResponseEntity<?> rejectRequest(@PathVariable Long requestId) {
        swapRequestService.rejectSwapRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
