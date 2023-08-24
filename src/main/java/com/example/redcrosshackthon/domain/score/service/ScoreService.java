package com.example.redcrosshackthon.domain.score.service;

import com.example.redcrosshackthon.domain.score.dto.request.ScoreRegisterReqDto;
import com.example.redcrosshackthon.domain.score.entity.Score;
import com.example.redcrosshackthon.domain.score.repository.ScoreRepository;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    @Transactional
    public void registerScore(ScoreRegisterReqDto scoreRegisterReqDto){
        Score newScore = buildScore(scoreRegisterReqDto);
        scoreRepository.save(newScore);
    }

    private Score buildScore(ScoreRegisterReqDto scoreRegisterReqDto){
        User newUser = userRepository.getById(scoreRegisterReqDto.getUser_id());
        return Score.builder()
                .user(newUser)
                .point(scoreRegisterReqDto.getPoint())
                .type(scoreRegisterReqDto.getType())
                .build();
    }
}
