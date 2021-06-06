package com.complexity.gaming.help_i.controller.application;

import com.complexity.gaming.help_i.domain.model.application.ExpertApplication;
import com.complexity.gaming.help_i.domain.service.application.ExpertApplicationService;
import com.complexity.gaming.help_i.resource.application.ExpertApplicationResource;
import com.complexity.gaming.help_i.resource.application.SaveExpertApplicationResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlayerApplicationController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExpertApplicationService expertApplicationService;

    @GetMapping("/players/{playerId}/Applications")
    public Page<ExpertApplicationResource> getAllExpertApplicationByApplicantId(@PathVariable Long playerId, Pageable pageable) {
        List<ExpertApplicationResource> applications = expertApplicationService.getAllExpertApplicationsByApplicantId(playerId, pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(applications, pageable, applications.size());
    }

    @PostMapping("/players/{playerId}/Applications")
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
