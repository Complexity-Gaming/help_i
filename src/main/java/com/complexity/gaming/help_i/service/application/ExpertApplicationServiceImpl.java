package com.complexity.gaming.help_i.service.application;

import com.complexity.gaming.help_i.domain.model.application.ExpertApplication;
import com.complexity.gaming.help_i.domain.model.security.Expert;
import com.complexity.gaming.help_i.domain.repository.application.ExpertApplicationRepository;
import com.complexity.gaming.help_i.domain.repository.security.ExpertRepository;
import com.complexity.gaming.help_i.domain.repository.security.PlayerRepository;
import com.complexity.gaming.help_i.domain.service.application.ExpertApplicationService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpertApplicationServiceImpl implements ExpertApplicationService {

    @Autowired
    private ExpertApplicationRepository expertApplicationRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ExpertRepository expertRepository;

    @Override
    public Page<ExpertApplication> getAllExpertApplications(Pageable pageable) {
        return expertApplicationRepository.findAll(pageable);
    }

    @Override
    public Page<ExpertApplication> getAllExpertApplicationsByApplicantId(Long playerId, Pageable pageable) {
        return expertApplicationRepository.findByPlayerId( playerId, pageable);
    }

    @Override
    public ExpertApplication getExpertApplicationById(Long expertApplicationId) {
        return expertApplicationRepository.findById(expertApplicationId).orElseThrow(
                ()-> new ResourceNotFoundException("application", "Id", expertApplicationId));
    }

    @Override
    public ExpertApplication sendExpertApplication(Long applicantId, ExpertApplication expertApplication) {
        return playerRepository.findById(applicantId).map(player -> {
            expertApplication.setPlayer(player);
            return expertApplicationRepository.save(expertApplication);
        }).orElseThrow(()-> new ResourceNotFoundException( "Player", "Id", applicantId));
    }

    @Override
    public Expert reviewApplication(Long expertApplicationId, String review, String reviewComment) {

        return null;
    }

    @Override
    public ResponseEntity<?> deleteExpertApplication(Long expertApplicationId) {
        return expertApplicationRepository.findById(expertApplicationId).map(expertApplication -> {
            expertApplicationRepository.delete(expertApplication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("application", "Id", expertApplicationId));
    }
}
