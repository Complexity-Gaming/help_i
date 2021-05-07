package com.complexity.gaming.help_i.controller;

import com.complexity.gaming.help_i.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.resouce.TrainingMaterialResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlayerTrainingMaterialsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @GetMapping("/players/{playerId}/trainings")
    public Page<TrainingMaterialResource> getAllTrainingMaterialsByPlayerIdId(@PathVariable Long playerId, Pageable pageable) {
        List<TrainingMaterialResource> trainings = trainingMaterialService.getAllTrainingMaterialsByPlayerId(playerId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(trainings, pageable, trainings.size());
    }

    @PostMapping("/players/{playerId}/trainings/{trainingId}")
    public TrainingMaterialResource purchaseTrainingMaterial(@PathVariable Long playerId,  @PathVariable Long trainingId) {
        return convertToResource(trainingMaterialService.purchaseTrainingMaterial(playerId, trainingId));
    }

    private TrainingMaterialResource convertToResource(TrainingMaterial entity) {
        return mapper.map(entity, TrainingMaterialResource.class);
    }
}
