package com.complexity.gaming.help_i.domain.service.Session;

import com.complexity.gaming.help_i.domain.model.Session.IndividualSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IndividualSessionService {

    Page<IndividualSession> getAllIndividualSessions(Pageable pageable);
    Page<IndividualSession> getAllIndividualSessionsByExpertId(Long expertId, Pageable pageable);
    Page<IndividualSession> getAllIndividualSessionsByPlayerId(Long playerId, Pageable pageable);
    IndividualSession getIndividualSessionById(Long individualSessionId);
    ResponseEntity<?> deleteIndividualSession(Long individualSessionId);
}
