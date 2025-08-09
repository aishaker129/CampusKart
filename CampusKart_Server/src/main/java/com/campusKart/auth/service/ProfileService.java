package com.campusKart.auth.service;

import com.campusKart.auth.Mapper.UserMapper;
import com.campusKart.auth.dto.ProfileRequest;
import com.campusKart.auth.dto.UserDto;
import com.campusKart.auth.entity.User;
import com.campusKart.auth.repository.UserRepo;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private UserRepo userRepo;
    private Cloudinary cloudinary;
    private UserMapper userMapper;

    public ProfileService(UserRepo userRepo, Cloudinary cloudinary, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.cloudinary = cloudinary;
        this.userMapper = userMapper;
    }
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateProfile(Long id, MultipartFile file, ProfileRequest user) throws IOException {

        User current_user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // delete existing image
        if (current_user.getImagePublicId() != null) {
            cloudinary.uploader().destroy(current_user.getImagePublicId(), ObjectUtils.emptyMap());
        }

        // upload new image
        Map uploadImage = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "profile_Image"));

        current_user.setName(user.getName());
        current_user.setEmail(user.getEmail());
        current_user.setDescription(user.getDescription());
        current_user.setUniversity(user.getUniversity());
        current_user.setImageUrl(uploadImage.get("secure_url").toString());
        current_user.setImagePublicId(uploadImage.get("public_id").toString());

        userRepo.save(current_user);
        return "Profile updated";
    }

    public String deleteProfile(Long id) throws IOException {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getImagePublicId() != null) {
            cloudinary.uploader().destroy(user.getImagePublicId(),ObjectUtils.emptyMap());
        }
        userRepo.delete(user);
        return "Profile deleted";
    }
}
