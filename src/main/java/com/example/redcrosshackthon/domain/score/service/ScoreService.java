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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        User user = userRepository.findById(userId).orElseThrow(() -> new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        List<Score> scores = scoreRepository.findByUser_Id(user.getId());
        List<ScoreInfoResDto> scoreList = scores.stream()
                .map(scoreMapper::entityToScoreInfo) // Score를 ScoreInfo로 매핑
                .collect(Collectors.toList());
        return scoreMapper.entityToScoresInfoDto(scoreList,user);
    }

    @Transactional
    public RankInfoResDto getRank(Long univId){
        University university = universityRepository.findById(univId).orElseThrow(()->new ErrorResponse(ErrorCode.UNIVERSITY_NOT_FOUND));
        List<User> users = userRepository.getUsersByTotalPoint();
        List<RankUserResDto> rank = IntStream.range(0, users.size())
                .mapToObj(index -> {
                    User user = users.get(index);
                    int rankValue = sumPointUser(user.getId());
                    int number = index + 1;
                    return scoreMapper.entityToRankUserDto(user, rankValue, number);
                })
                .collect(Collectors.toList());
        RankInfoResDto rankList = scoreMapper.entityToRankInfoDto(university,rank);
        return rankList;
    }


    public int sumPointUser(Long userId){
        Integer sumPoints = scoreRepository.sumPointsByUserId(userId);
        if(sumPoints ==null) return 0;
        return sumPoints;
    }

}
