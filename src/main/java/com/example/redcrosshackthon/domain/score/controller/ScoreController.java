package com.example.redcrosshackthon.domain.score.controller;

import com.example.redcrosshackthon.domain.score.dto.request.ScoreRegisterReqDto;
import com.example.redcrosshackthon.domain.score.dto.response.RankInfoResDto;
import com.example.redcrosshackthon.domain.score.dto.response.ScoresUserInfoResDto;
import com.example.redcrosshackthon.domain.score.service.ScoreService;
import com.example.redcrosshackthon.global.response.ResultCode;
import com.example.redcrosshackthon.global.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class ScoreController {
    private final ScoreService scoreService;
    @PostMapping("/score")
    public ResponseEntity<ResultResponse> registerScore(@RequestBody ScoreRegisterReqDto scoreRegisterReqDto){
        scoreService.registerScore(scoreRegisterReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResultResponse.of(ResultCode.SCORE_REGISTER_SUCCESS));
    }

    @GetMapping("/score/{user_id}")
    public ResponseEntity<ScoresUserInfoResDto> getScore(@PathVariable("user_id") Long userId){
        ScoresUserInfoResDto scores = scoreService.getScores(userId);
        return ResponseEntity.status(HttpStatus.OK).body(scores);
    }

    @GetMapping("/rank/{university_id}")
    public ResponseEntity<RankInfoResDto> getRank(@PathVariable("university_id") Long univId){
        RankInfoResDto rank = scoreService.getRank(univId);
        return ResponseEntity.status(HttpStatus.OK).body(rank);
    }

    @GetMapping("/rank/{university_id}/top3")
    public ResponseEntity<RankInfoResDto> getRankTop3(@PathVariable("university_id") Long univId){
        RankInfoResDto rankTop3 = scoreService.getRankTop3(univId);
        return ResponseEntity.status(HttpStatus.OK).body(rankTop3);
    }
}
