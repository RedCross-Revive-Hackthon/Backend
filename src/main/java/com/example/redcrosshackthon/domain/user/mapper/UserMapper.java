package com.example.redcrosshackthon.domain.user.mapper;

import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoResDto entityToUserInfo(User user,Long universityId) {
        return UserInfoResDto.builder()
                .university_id(universityId)
                .user_id(user.getUser_id())
                .name(user.getName())
                .email(user.getEmail())
                .department(user.getDepartment())
                .build();
    }
}