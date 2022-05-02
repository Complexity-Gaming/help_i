package com.complexity.gaming.help_i.application.interfaces.rest;

import com.complexity.gaming.help_i.application.domain.model.aggregate.ExpertApplication;
import com.complexity.gaming.help_i.application.domain.service.ExpertApplicationService;
import com.complexity.gaming.help_i.application.application.transform.resource.ExpertApplicationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class ApplicationController {

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private ExpertApplicationService expertApplicationService;

    @Operation(summary = "Get all applications", description = "Get all applications", tags = {"applications"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/applications")
    public Page<ExpertApplicationResource> getAllExpertApplications(Pageable pageable) {
        List<ExpertApplicationResource> tags = expertApplicationService.getAllExpertApplications(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }
    @Operation(summary = "Get application by id", description = "Get application by id", tags = {"applications"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/applications/{id}")
    public ExpertApplicationResource getExpertApplicationById(@PathVariable(name = "id") Long trainingId) {
        return convertToResource(expertApplicationService.getExpertApplicationById(trainingId));
    }
    @Operation(summary = "Delete application by id", description = "Delete application by id", tags = {"applications"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @DeleteMapping("/applications/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return expertApplicationService.deleteExpertApplication(id);
    }
    
    private ExpertApplicationResource convertToResource(ExpertApplication entity){
        return mapper.map(entity, ExpertApplicationResource.class);
    }
}
