package com.campusKart.auth.dto;

import lombok.Data;

@Data
public class ProfileRequest {
    private String name;
    private String email;
    private String description;
    private String university;
    private String imageUrl;
}
