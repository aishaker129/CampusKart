package com.campusKart.auth.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    @Size(message = "min length 6")
    private String password;
    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean verified=false;
    @Column(columnDefinition = "TEXT")
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String imagePublicId;

    @Enumerated(EnumType.STRING)
    private Role role;


}
