package com.complexity.gaming.help_i.session.domain.repository;

import com.complexity.gaming.help_i.session.domain.model.IndividualSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualSessionRepository extends JpaRepository<IndividualSession, Long> {

    Page<IndividualSession> findByExpertId(Long expertId, Pageable pageable);
    Page<IndividualSession> findByPlayerId(Long playerId, Pageable pageable);
    Page<IndividualSession> findByPlayerIdAndExpertId(Long playerId, Long expertId, Pageable pageable);
}
