package com.campusKart.config;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${config.cloudinary.cloud.name}")
    private String name;

    @Value("${config.cloudinary.cloud.key}")
    private String key;

    @Value("${config.cloudinary.cloud.secret}")
    private String secret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", name,
                "api_key", key,
                "api_secret", secret
        ));
    }
}
