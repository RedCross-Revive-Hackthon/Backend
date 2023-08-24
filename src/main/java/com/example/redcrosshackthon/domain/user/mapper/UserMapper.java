package com.example.redcrosshackthon.domain.user.mapper;

import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoResDto entityToUserInfo(User user, University university) {
        return UserInfoResDto.builder()
                .univName(university.getUnivName())
                .name(user.getName())
                .department(user.getDepartment())
//                .score()
//                .rank()
                .build();
    }
}