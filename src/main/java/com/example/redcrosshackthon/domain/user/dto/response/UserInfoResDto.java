package com.example.redcrosshackthon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResDto {
    private String univName;
    private String name;
    private String department;
    private int score;
    private int rank;
}

