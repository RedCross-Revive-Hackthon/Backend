package com.example.redcrosshackthon.domain.score.mapper;

import com.example.redcrosshackthon.domain.score.dto.response.RankInfoResDto;
import com.example.redcrosshackthon.domain.score.dto.response.ScoreInfoResDto;
import com.example.redcrosshackthon.domain.score.dto.response.ScoresUserInfoResDto;
import com.example.redcrosshackthon.domain.score.entity.Score;
import com.example.redcrosshackthon.domain.university.entity.University;
import com.example.redcrosshackthon.domain.user.dto.response.RankUserResDto;
import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoreMapper {

    public ScoreInfoResDto entityToScoreInfo(Score score) {
        return ScoreInfoResDto.builder()
                .point(score.getPoint())
                .type(score.getType())
                .build();
    }

    public ScoresUserInfoResDto entityToScoresInfoDto(List<ScoreInfoResDto> scores, User user) {
        return ScoresUserInfoResDto.builder()
                .user(user)
                .scores(scores)
                .build();
    }

    public RankUserResDto entityToRankUserDto(User user,int sumPoints,int rank){
        return RankUserResDto.builder()
                .userId(user.getId())
                .name(user.getName())
                .department(user.getDepartment())
                .image(user.getImage())
                .score(sumPoints)
                .rank(rank)
                .build();
    }

    public RankInfoResDto entityToRankInfoDto (University university,List<RankUserResDto> users){
        return RankInfoResDto.builder()
                .UnivName(university.getUnivName())
                .userList(users)
                .build();
    }

}


