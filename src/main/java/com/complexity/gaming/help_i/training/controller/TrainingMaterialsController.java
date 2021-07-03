package com.complexity.gaming.help_i.training.controller;

import com.complexity.gaming.help_i.training.domain.model.TrainingMaterial;
import com.complexity.gaming.help_i.training.domain.service.TrainingMaterialService;
import com.complexity.gaming.help_i.training.resource.TrainingMaterialResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TrainingMaterialsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrainingMaterialService trainingMaterialService;

    @GetMapping("/trainings")
    public Page<TrainingMaterialResource> getAllTrainingMaterials(Pageable pageable) {
        List<TrainingMaterialResource> tags = trainingMaterialService.getAllTrainingMaterials(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }
    @GetMapping("/trainings/{id}")
    public TrainingMaterialResource getTrainingMaterialById(@PathVariable(name = "id") Long trainingId) {
        return convertToResource(trainingMaterialService.getTrainingMaterialById(trainingId));
    }
    @DeleteMapping("/trainings/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return trainingMaterialService.deleteTrainingMaterial(id);
    }

    private TrainingMaterialResource convertToResource(TrainingMaterial entity) {
        return mapper.map(entity, TrainingMaterialResource.class);
    }
}
