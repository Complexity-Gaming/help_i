package com.complexity.gaming.help_i.training.domain.service;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TrainingMaterialService {
    Page<TrainingMaterial> getAllTrainingMaterials(Pageable pageable);
    Page<TrainingMaterial> getAllTrainingMaterialsByExpertId(Long expertId, Pageable pageable);
    Page<TrainingMaterial> getAllTrainingMaterialsByGameId(Long gameId, Pageable pageable);
    Page<TrainingMaterial> getAllTrainingMaterialsByPlayerId(Long playerId, Pageable pageable);
    TrainingMaterial getTrainingMaterialById(Long trainingMaterialId);
    TrainingMaterial publishTrainingMaterial(Long expertId, TrainingMaterial trainingMaterial);
    TrainingMaterial purchaseTrainingMaterial(Long playerId, Long trainingMaterialId);
    ResponseEntity<?> deleteTrainingMaterial(Long trainingMaterialId);
}
