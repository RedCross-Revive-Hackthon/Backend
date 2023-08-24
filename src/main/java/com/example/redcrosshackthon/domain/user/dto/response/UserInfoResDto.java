package com.example.redcrosshackthon.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResDto {
    private Long university_id;
    private String user_id;
    private String name;
    private String email;
    private String department;
}

