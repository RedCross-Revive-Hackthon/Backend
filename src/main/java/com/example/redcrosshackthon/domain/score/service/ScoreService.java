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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final ScoreMapper scoreMapper;
    private final UniversityRepository universityRepository;

    @Transactional
    public void registerScore(ScoreRegisterReqDto scoreRegisterReqDto){
        Score newScore = buildScore(scoreRegisterReqDto);
        User user = userRepository.findById(newScore.getUser().getId()).orElseThrow(()->new ErrorResponse(ErrorCode.USER_NOT_FOUND));
        user.setPoint(newScore.getPoint());
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

    public ScoresUserInfoResDto getScores(Long userId){
        List<Score> scores = scoreRepository.findByUser_Id(userId);
        List<ScoreInfoResDto> scoreList = buildScore(scores);
        return scoreMapper.entityToScoresInfoDto(userId,scoreList);
    }

    private List<ScoreInfoResDto> buildScore(List<Score> scores){
        return scores.stream().map(score -> ScoreInfoResDto.builder()
                        .point(score.getPoint())
                        .type(score.getType())
                        .build())
                .collect(Collectors.toList());
    }


    public RankInfoResDto getRank(Long univId){
        List<User> users = userRepository.findByUniversityIdOrderByPointDesc(univId);
        return getRankInfoResDto(univId, users);
    }

    private List<RankUserResDto> buildRank(List<User> users, AtomicInteger ranking) {
        List<RankUserResDto> rank = users.stream().map(user -> RankUserResDto.builder()
                .name(user.getName())
                .image(user.getImage())
                .score(user.getPoint())
                .department(user.getDepartment())
                .rank(ranking.addAndGet(1))
                .build()).collect(Collectors.toList());
        return rank;
    }

    public RankInfoResDto getRankTop3(Long univId){
        List<User> users = userRepository.findTop3ByUniversityIdOrderByPointDesc(univId);
        return getRankInfoResDto(univId, users);
    }

    private RankInfoResDto getRankInfoResDto(Long univId, List<User> users) {
        University university = universityRepository.findById(univId).orElseThrow(()-> new ErrorResponse(ErrorCode.UNIVERSITY_NOT_FOUND));
        AtomicInteger ranking = new AtomicInteger(0);
        List<RankUserResDto> rank = buildRank(users, ranking);
        RankInfoResDto rankList = scoreMapper.entityToRankInfoDto(university.getUnivName(),rank);
        return rankList;
    }

}
