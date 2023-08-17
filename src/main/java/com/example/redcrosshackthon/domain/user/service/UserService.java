package com.example.redcrosshackthon.domain.user.service;

import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;

public interface UserService {
    UserInfoResDto signup(UserRegisterReqDto userRegisterReqDto);
}
