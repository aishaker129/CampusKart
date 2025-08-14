package com.campusKart.entity;

import com.campusKart.auth.entity.User;
import com.campusKart.entity.Enum.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "SwapProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwapRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    private String offeredItemDescription;
    private LocalDateTime requestDate;
    private boolean accepted;
}
