package com.example.redcrosshackthon.domain.user.service;

import com.example.redcrosshackthon.domain.score.repository.ScoreRepository;
import com.example.redcrosshackthon.domain.score.service.ScoreService;
import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.user.dto.request.UserRegisterReqDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.mapper.UserMapper;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import com.example.redcrosshackthon.global.error.ErrorCode;
import com.example.redcrosshackthon.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Transactional
    public Long createUser(User user){
        User getUser = userRepository.save(user);
        return getUser.getId();
    }
    public UserInfoResDto getUser(Long userId){
        User user = findUser(userId);
        return userMapper.entityToUserInfo(user);
    }

    private User findUser(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new ErrorResponse(ErrorCode.USER_NOT_FOUND));
    }
}
