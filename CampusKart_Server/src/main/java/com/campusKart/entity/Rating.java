package com.campusKart.entity;

import com.campusKart.auth.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rate;// 0-5

    @ManyToOne
    private User fromUser;
    @ManyToOne
    private User toUser;
    private LocalDateTime createdAt;
}
