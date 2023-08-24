package com.example.redcrosshackthon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankUserResDto {
    private Long userId;
    private String name;
    private String department;
    private String image;
    private int score;
    private int rank;
}