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
    @Lob
    private String description;

    private boolean verified;
    @Lob
    private String imageUrl;
    @Lob
    private String imagePublicId;

    @Enumerated(EnumType.STRING)
    private Role role;


}
