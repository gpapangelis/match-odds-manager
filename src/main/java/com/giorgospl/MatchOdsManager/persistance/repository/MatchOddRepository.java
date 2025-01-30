package com.giorgospl.MatchOdsManager.persistance.repository;

import com.giorgospl.MatchOdsManager.persistance.entity.MatchOddEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchOddRepository extends JpaRepository<MatchOddEntity, Integer> {
    Optional<MatchOddEntity> findByOddIdAndMatch_MatchId(String oddId, String matchId);
}
