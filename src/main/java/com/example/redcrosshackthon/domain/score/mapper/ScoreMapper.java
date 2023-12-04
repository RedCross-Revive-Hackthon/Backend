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

    public ScoresUserInfoResDto entityToScoresInfoDto(Long userId,List<ScoreInfoResDto> scores) {
        return ScoresUserInfoResDto.builder()
                .userId(userId)
                .scores(scores)
                .build();
    }

    public RankUserResDto entityToRankUserDto(User user,int sumPoints,int rank){
        return RankUserResDto.builder()
                .name(user.getName())
                .department(user.getDepartment())
                .image(user.getImage())
                .score(sumPoints)
                .rank(rank)
                .build();
    }

    public RankInfoResDto entityToRankInfoDto (String univName,List<RankUserResDto> rank){
        return RankInfoResDto.builder()
                .UnivName(univName)
                .userList(rank)
                .build();
    }

}


