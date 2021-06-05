package com.complexity.gaming.help_i.service.Session;

import com.complexity.gaming.help_i.domain.model.Security.Expert;
import com.complexity.gaming.help_i.domain.model.Session.ScheduledSession;
import com.complexity.gaming.help_i.domain.repository.Security.ExpertRepository;
import com.complexity.gaming.help_i.domain.repository.Security.PlayerRepository;
import com.complexity.gaming.help_i.domain.repository.Session.ScheduledSessionRepository;
import com.complexity.gaming.help_i.domain.service.Session.ScheduledSessionService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduledSessionServiceImpl implements ScheduledSessionService {

    @Autowired
    private ScheduledSessionRepository scheduledSessionRepository;

    @Autowired
    private ExpertRepository expertRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<ScheduledSession> getAllScheduledSessions(Pageable pageable) {
        return scheduledSessionRepository.findAll(pageable);
    }

    @Override
    public Page<ScheduledSession> getAllScheduledSessionsByExpertId(Long expertId, Pageable pageable) {
        return scheduledSessionRepository.findByExpertId(expertId, pageable);
    }

    @Override
    public Page<ScheduledSession> getAllScheduledSessionsByPlayerId(Long playerId, Pageable pageable) {
        return scheduledSessionRepository.findByPlayerId(playerId, pageable);
    }

    @Override
    public ScheduledSession getScheduledSessionById(Long scheduledSessionId) {
        return scheduledSessionRepository.findById(scheduledSessionId).orElseThrow(
                () -> new ResourceNotFoundException("Scheduled", "Id", scheduledSessionId));
    }

    @Override
    public ScheduledSession ScheduleSession(Long expertId,Long playerId, ScheduledSession scheduledSession) {
        Expert expert = expertRepository.findById(expertId).orElseThrow(
                () -> new ResourceNotFoundException("Expert","Id",expertId));
        return playerRepository.findById(playerId).map(player -> {
            scheduledSession.setPlayer(player);
            scheduledSession.setExpert(expert);
            return scheduledSessionRepository.save(scheduledSession);
        }).orElseThrow(()-> new ResourceNotFoundException( "Player", "Id", playerId));
    }

    @Override
    public ResponseEntity<?> deleteScheduledSession(Long scheduledSessionId) {
        return scheduledSessionRepository.findById(scheduledSessionId).map(scheduledSession -> {
            scheduledSessionRepository.delete(scheduledSession);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Scheduled", "Id", scheduledSessionId));
    }
}
