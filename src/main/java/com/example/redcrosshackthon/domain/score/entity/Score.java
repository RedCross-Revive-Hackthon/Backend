package com.example.redcrosshackthon.domain.score.entity;

import com.example.redcrosshackthon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "score")
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socre_id")
    private Long id;

    private int point;

    private String type;

    @CreatedDate
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Score(User user,int point, String type) {
        this.user = user;
        this.point = point;
        this.type = type;
    }
}
