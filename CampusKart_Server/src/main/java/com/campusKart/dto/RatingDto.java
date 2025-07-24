package com.campusKart.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {

    private int rate;
    private String comment;
    private Long touUserId;

}
