package com.example.redcrosshackthon.domain.user.mapper;

import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User signupRequestToEntity(UserRegisterReqDto userRegisterReqDto){
        return User.builder()
                .name(userRegisterReqDto.getName())
                .email(userRegisterReqDto.getEmail())
                .build();
    }

    public UserInfoResDto entityToUserInfo(User registerUser) {
        return UserInfoResDto.builder()
                .name(registerUser.getName())
                .email(registerUser.getEmail())
                .build();
    }
}