package com.complexity.gaming.help_i.application.interfaces.rest;

import com.complexity.gaming.help_i.application.domain.model.aggregate.ExpertApplication;
import com.complexity.gaming.help_i.application.domain.service.ExpertApplicationService;
import com.complexity.gaming.help_i.application.application.transform.resource.ExpertApplicationResource;
import com.complexity.gaming.help_i.application.application.transform.resource.SaveExpertApplicationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class PlayerApplicationController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExpertApplicationService expertApplicationService;

    @Operation(summary = "Get all applications for a player Id", description = "Get all applications for a player Id", tags = {"player-applications"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/players/{playerId}/applications")
    public Page<ExpertApplicationResource> getAllExpertApplicationByApplicantId(@PathVariable Long playerId, Pageable pageable) {
        List<ExpertApplicationResource> applications = expertApplicationService.getAllExpertApplicationsByApplicantId(playerId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(applications, pageable, applications.size());
    }
    @Operation(summary = "Create a new application with a player Id", description = "Create a new application with a player Id", tags = {"player-applications"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PostMapping("/players/{playerId}/applications")
    public ExpertApplicationResource sendExpertApplication(@PathVariable Long playerId,
                                                            @Valid @RequestBody SaveExpertApplicationResource resource) {
        return convertToResource(expertApplicationService.sendExpertApplication(playerId, convertToEntity(resource)));
    }

    ExpertApplication convertToEntity(SaveExpertApplicationResource resource){
        return mapper.map(resource, ExpertApplication.class);
    }

    private ExpertApplicationResource convertToResource(ExpertApplication entity){
        return mapper.map(entity, ExpertApplicationResource.class);
    }
}
