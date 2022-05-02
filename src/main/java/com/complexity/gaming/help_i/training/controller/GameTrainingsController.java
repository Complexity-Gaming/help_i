package com.complexity.gaming.help_i.training.controller;

import com.complexity.gaming.help_i.security.application.transform.resource.ExpertResource;
import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.service.ExpertService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/api/games/{gameId}/trainings")
public class GameTrainingsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @Operation(summary = "Get all trainings for a game Id", description = "Get all trainings for a game Id", tags = {"game-trainings"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping
    public Page<TrainingMaterialResource> getAllTrainingsByGameId(Pageable pageable, @PathVariable(name = "gameId") Long gameId){
        List<TrainingMaterialResource> games = trainingMaterialService.getAllTrainingMaterialsByGameId(gameId,pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(games, pageable, games.size());
    }
    private TrainingMaterialResource convertToResource(TrainingMaterial entity) {
        return mapper.map(entity, TrainingMaterialResource.class);
    }
}
