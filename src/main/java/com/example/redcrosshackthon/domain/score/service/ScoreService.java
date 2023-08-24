package com.example.redcrosshackthon.domain.score.service;

import com.example.redcrosshackthon.domain.score.dto.request.ScoreRegisterReqDto;
import com.example.redcrosshackthon.domain.score.dto.response.RankInfoResDto;
import com.example.redcrosshackthon.domain.score.dto.response.ScoreInfoResDto;
import com.example.redcrosshackthon.domain.score.dto.response.ScoresUserInfoResDto;
import com.example.redcrosshackthon.domain.score.entity.Score;
import com.example.redcrosshackthon.domain.score.mapper.ScoreMapper;
import com.example.redcrosshackthon.domain.score.repository.ScoreRepository;
import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.university.repository.UniversityRepository;
import com.example.redcrosshackthon.domain.user.dto.response.RankUserResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import com.example.redcrosshackthon.domain.user.repository.UserRepository;
import com.example.redcrosshackthon.global.error.ErrorCode;
import com.example.redcrosshackthon.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final ScoreMapper scoreMapper;
    private final UniversityRepository universityRepository;

    @Transactional
    public void registerScore(ScoreRegisterReqDto scoreRegisterReqDto){
        Score newScore = buildScore(scoreRegisterReqDto);
        scoreRepository.save(newScore);
    }

    private Score buildScore(ScoreRegisterReqDto scoreRegisterReqDto){
        User newUser = userRepository.findById(scoreRegisterReqDto.getUser_id()).orElseThrow(()->new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        return Score.builder()
                .user(newUser)
                .point(scoreRegisterReqDto.getPoint())
                .type(scoreRegisterReqDto.getType())
                .build();
    }

    @Transactional
    public ScoresUserInfoResDto getScore(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        List<Score> scores = scoreRepository.findByUser_Id(user.getId());
        List<ScoreInfoResDto> scoreList = scores.stream()
                .map(scoreMapper::entityToScoreInfo) // Score를 ScoreInfo로 매핑
                .collect(Collectors.toList());
        return scoreMapper.entityToScoresInfoDto(scoreList,user);
    }

    @Transactional
    public List<RankInfoResDto> getRankTop3(Long univId){
        University university = universityRepository.findById(univId).orElseThrow(()->new ErrorResponse(ErrorCode.UNIVERSITY_NOT_FOUND));
        List<RankUserResDto> rankUserResDto = userRepository.getUserScores();
        List<RankInfoResDto> rankList = rankUserResDto.stream()
                .map(userDto -> {
                    return scoreMapper.entityToRankInfoDto(university, (List<RankUserResDto>) userDto);
                })
                .collect(Collectors.toList());
        return rankList;
    }

    public int sumPointUser(Long userId){
        Integer sumPoints = scoreRepository.sumPointsByUserId(userId);
        return sumPoints;
    }

    private RankUserResDto rankUserResDto(User user, int sumPoints,int rank){
        return scoreMapper.entityToRankUserDto(user,sumPoints,rank);
    }
}
