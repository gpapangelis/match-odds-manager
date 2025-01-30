package com.giorgospl.MatchOdsManager.persistance.repository;

import com.giorgospl.MatchOdsManager.persistance.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<MatchEntity, Integer> {
    Optional<MatchEntity> findByMatchId(String matchId);
}
