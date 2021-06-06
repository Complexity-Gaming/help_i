package com.complexity.gaming.help_i.domain.service.session;

import com.complexity.gaming.help_i.domain.model.session.ScheduledSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ScheduledSessionService {

    Page<ScheduledSession> getAllScheduledSessions(Pageable pageable);
    Page<ScheduledSession> getAllScheduledSessionsByExpertId(Long expertId, Pageable pageable);
    Page<ScheduledSession> getAllScheduledSessionsByPlayerId(Long playerId, Pageable pageable);
    ScheduledSession getScheduledSessionById(Long scheduledSessionId);
    ScheduledSession ScheduleSession(Long expertId,Long playerId, ScheduledSession scheduledSession);
    ResponseEntity<?> deleteScheduledSession(Long scheduledSessionId);
}