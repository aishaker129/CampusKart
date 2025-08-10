package com.campusKart.auth.controller;

import com.campusKart.auth.dto.ProfileRequest;
import com.campusKart.auth.dto.UserDto;
import com.campusKart.auth.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class ProfileController {
    private ProfileService profileService;
    private ObjectMapper objectMapper;

    public ProfileController(ProfileService profileService, ObjectMapper objectMapper) {
        this.profileService = profileService;
        this.objectMapper = objectMapper;
    }


    @PutMapping("/{id}/update-profile")
    public ResponseEntity<?> updateProfile(@PathVariable("id") Long id, @RequestParam("user") String userJson, @RequestParam("image") MultipartFile file) throws IOException {
        ProfileRequest dto = objectMapper.readValue(userJson, ProfileRequest.class);
        return ResponseEntity.ok(profileService.updateProfile(id,file,dto));
    }

    @DeleteMapping("/{id}/delete-profile")
    public ResponseEntity<?> deleteProfile(@PathVariable("id") Long id) throws IOException {
        return ResponseEntity.ok(profileService.deleteProfile(id));

    }
}
