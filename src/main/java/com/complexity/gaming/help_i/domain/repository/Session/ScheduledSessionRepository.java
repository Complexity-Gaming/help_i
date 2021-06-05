package com.complexity.gaming.help_i.domain.repository.Session;

import com.complexity.gaming.help_i.domain.model.Session.ScheduledSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledSessionRepository extends JpaRepository<ScheduledSession, Long> {

    Page<ScheduledSession> findByExpertId(Long expertId, Pageable pageable);
    Page<ScheduledSession> findByPlayerId(Long playerId, Pageable pageable);
    Page<ScheduledSession> findByPlayerIdAndExpertId(Long playerId, Long expertId, Pageable pageable);
}
