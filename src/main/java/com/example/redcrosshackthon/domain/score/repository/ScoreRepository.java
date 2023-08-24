package com.example.redcrosshackthon.domain.score.repository;

import com.example.redcrosshackthon.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    List<Score> findByUser_Id(Long userId);
}
