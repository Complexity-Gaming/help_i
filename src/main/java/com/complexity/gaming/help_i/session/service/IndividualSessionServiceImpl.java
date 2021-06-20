package com.complexity.gaming.help_i.session.service;

import com.complexity.gaming.help_i.session.domain.model.IndividualSession;
import com.complexity.gaming.help_i.session.domain.repository.IndividualSessionRepository;
import com.complexity.gaming.help_i.session.domain.service.IndividualSessionService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IndividualSessionServiceImpl implements IndividualSessionService {

    @Autowired
    private IndividualSessionRepository individualSessionRepository;

    @Override
    public Page<IndividualSession> getAllIndividualSessions(Pageable pageable) {
        return individualSessionRepository.findAll(pageable);
    }

    @Override
    public Page<IndividualSession> getAllIndividualSessionsByExpertId(Long expertId, Pageable pageable) {
        return individualSessionRepository.findByExpertId(expertId, pageable);
    }

    @Override
    public Page<IndividualSession> getAllIndividualSessionsByPlayerId(Long playerId, Pageable pageable) {
        return individualSessionRepository.findByPlayerId(playerId, pageable);
    }

    @Override
    public IndividualSession getIndividualSessionById(Long individualSessionId) {
        return individualSessionRepository.findById(individualSessionId).orElseThrow(
                ()-> new ResourceNotFoundException("session", "Id", individualSessionId));
    }

    @Override
    public ResponseEntity<?> deleteIndividualSession(Long individualSessionId) {
        return individualSessionRepository.findById(individualSessionId).map(individualSession -> {
            individualSessionRepository.delete(individualSession);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("session", "Id", individualSessionId));
    }
}
