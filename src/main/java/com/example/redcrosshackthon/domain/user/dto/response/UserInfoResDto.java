package com.example.redcrosshackthon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResDto {
    private String name;
    private String email;
}

