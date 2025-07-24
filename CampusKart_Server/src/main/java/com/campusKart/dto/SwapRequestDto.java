package com.campusKart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwapRequestDto {
    private Long productId;
    private String offeredItemDescription;
}
