package com.complexity.gaming.help_i.training.controller;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.training.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.training.resource.TrainingMaterialResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlayerTrainingMaterialsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @Operation(summary = "Get all trainings for a player Id", description = "Get all trainings for a player Id", tags = {"player-trainingMaterials"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @GetMapping("/players/{playerId}/trainings")
    public Page<TrainingMaterialResource> getAllTrainingMaterialsByPlayerIdId(@PathVariable Long playerId, Pageable pageable) {
        List<TrainingMaterialResource> trainings = trainingMaterialService.getAllTrainingMaterialsByPlayerId(playerId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(trainings, pageable, trainings.size());
    }

    @Operation(summary = "Get a training by id and player id", description = "Get a training by id and player id", tags = {"player-trainingMaterials"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @PostMapping("/players/{playerId}/trainings/{trainingId}")
    public TrainingMaterialResource purchaseTrainingMaterial(@PathVariable Long playerId,  @PathVariable Long trainingId) {
        return convertToResource(trainingMaterialService.purchaseTrainingMaterial(playerId, trainingId));
    }

    private TrainingMaterialResource convertToResource(TrainingMaterial entity) {
        return mapper.map(entity, TrainingMaterialResource.class);
    }
}
