package com.example.redcrosshackthon.domain.user.service;

import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.mapper.UserMapper;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import com.example.redcrosshackthon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Transactional
    public UserInfoResDto signup(UserRegisterReqDto userRegisterReqDto) {
        User newUser = userMapper.signupRequestToEntity(userRegisterReqDto);
        User registerUser = userRepository.save(newUser);
        return userMapper.entityToUserInfo(registerUser);
    }
}
