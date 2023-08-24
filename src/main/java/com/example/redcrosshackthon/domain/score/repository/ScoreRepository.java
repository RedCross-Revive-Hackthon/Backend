package com.example.redcrosshackthon.domain.score.repository;

import com.example.redcrosshackthon.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {
}
