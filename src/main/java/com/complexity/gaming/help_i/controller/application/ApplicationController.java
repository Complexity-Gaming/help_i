package com.complexity.gaming.help_i.controller.application;

import com.complexity.gaming.help_i.domain.model.application.ExpertApplication;
import com.complexity.gaming.help_i.domain.service.application.ExpertApplicationService;
import com.complexity.gaming.help_i.resource.application.ExpertApplicationResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private ExpertApplicationService expertApplicationService;

    @GetMapping("/applications")
    public Page<ExpertApplicationResource> getAllExpertApplications(Pageable pageable) {
        List<ExpertApplicationResource> tags = expertApplicationService.getAllExpertApplications(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }
    @GetMapping("/applications/{id}")
    public ExpertApplicationResource getExpertApplicationById(@PathVariable(name = "id") Long trainingId) {
        return convertToResource(expertApplicationService.getExpertApplicationById(trainingId));
    }
    @DeleteMapping("/applications/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return expertApplicationService.deleteExpertApplication(id);
    }
    
    private ExpertApplicationResource convertToResource(ExpertApplication entity){
        return mapper.map(entity, ExpertApplicationResource.class);
    }
}
