package com.complexity.gaming.help_i.training.controller;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.training.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.training.resource.SaveTrainingMaterialResource;
import com.complexity.gaming.help_i.training.resource.TrainingMaterialResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExpertTrainingMaterialsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @GetMapping("/experts/{expertId}/trainings")
    public Page<TrainingMaterialResource> getAllTrainingMaterialsByExpertId(@PathVariable Long expertId, Pageable pageable) {
        List<TrainingMaterialResource> trainings = trainingMaterialService.getAllTrainingMaterialsByExpertId(expertId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(trainings, pageable, trainings.size());
    }

    @PostMapping("/experts/{expertId}/trainings")
    public TrainingMaterialResource publishTrainingMaterial(@PathVariable Long expertId,
                                                           @Valid @RequestBody SaveTrainingMaterialResource resource) {
        return convertToResource(trainingMaterialService.publishTrainingMaterial(expertId, convertToEntity(resource)));
    }

    TrainingMaterial convertToEntity(SaveTrainingMaterialResource resource) {
        return mapper.map(resource, TrainingMaterial.class);
    }
    private TrainingMaterialResource convertToResource(TrainingMaterial entity) {
        return mapper.map(entity, TrainingMaterialResource.class);
    }
}
