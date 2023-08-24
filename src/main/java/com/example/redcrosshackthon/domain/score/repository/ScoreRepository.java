package com.example.redcrosshackthon.domain.score.repository;

import com.example.redcrosshackthon.domain.score.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    List<Score> findByUser_Id(Long userId);

    @Query("SELECT SUM(s.point) FROM Score s WHERE s.user.id = :userId")
    Integer sumPointsByUserId(@Param("userId") Long userId);

}
