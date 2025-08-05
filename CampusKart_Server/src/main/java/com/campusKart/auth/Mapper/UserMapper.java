package com.campusKart.auth.Mapper;

import com.campusKart.auth.dto.UserDto;
import com.campusKart.auth.entity.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {
    public UserDto toDTO(User user) {
        UserDto dto = new UserDto();
        dto.setId(String.valueOf(user.getId()));
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setDescription(user.getDescription());
        dto.setUniversity(user.getUniversity());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
