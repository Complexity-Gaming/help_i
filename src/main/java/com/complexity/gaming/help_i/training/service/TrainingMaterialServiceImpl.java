package com.complexity.gaming.help_i.training.service;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.security.domain.repository.ExpertRepository;
import com.complexity.gaming.help_i.security.domain.repository.PlayerRepository;
import com.complexity.gaming.help_i.training.domain.repository.TrainingMaterialRepository;
import com.complexity.gaming.help_i.training.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingMaterialServiceImpl implements TrainingMaterialService {

    @Autowired
    private TrainingMaterialRepository trainingMaterialRepository;

    @Autowired
    private ExpertRepository expertRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<TrainingMaterial> getAllTrainingMaterials(Pageable pageable) {
        return trainingMaterialRepository.findAll(pageable);
    }

    @Override
    public Page<TrainingMaterial> getAllTrainingMaterialsByExpertId(Long expertId, Pageable pageable) {
        return trainingMaterialRepository.findByExpertId(expertId, pageable);
    }

    @Override
    public Page<TrainingMaterial> getAllTrainingMaterialsByGameId(Long gameId, Pageable pageable) {
        return trainingMaterialRepository.findByGame(gameId, pageable);
    }

    @Override
    public Page<TrainingMaterial> getAllTrainingMaterialsByPlayerId(Long playerId, Pageable pageable) {
        return playerRepository.findById(playerId).map(player -> {
            List<TrainingMaterial> trainings = player.getTrainings();
            return new PageImpl<>(trainings, pageable, trainings.size());
        }).orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
    }

    @Override
    public TrainingMaterial getTrainingMaterialById(Long trainingMaterialId) {
        return trainingMaterialRepository.findById(trainingMaterialId).orElseThrow(
                () -> new ResourceNotFoundException("training", "Id", trainingMaterialId));
    }

    @Override
    public TrainingMaterial publishTrainingMaterial(Long expertId, TrainingMaterial trainingMaterial) {
        return expertRepository.findById(expertId).map(expert -> {
            trainingMaterial.setExpert(expert);
            return trainingMaterialRepository.save(trainingMaterial);
        }).orElseThrow(()-> new ResourceNotFoundException( "Expert", "Id", expertId));
    }

    @Override
    public TrainingMaterial purchaseTrainingMaterial(Long playerId, Long trainingMaterialId) {
        TrainingMaterial training = trainingMaterialRepository.findById(trainingMaterialId).orElseThrow(
                () -> new ResourceNotFoundException("training Material", "Id", trainingMaterialId));
        return playerRepository.findById(playerId).map(
                player -> {
                    playerRepository.save(player.purchaseTrainingMaterial(training));
                    return training;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
    }

    @Override
    public ResponseEntity<?> deleteTrainingMaterial(Long trainingMaterialId) {
        return trainingMaterialRepository.findById(trainingMaterialId).map(trainingMaterial -> {
            trainingMaterialRepository.delete(trainingMaterial);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("training", "Id", trainingMaterialId));
    }
}
