package com.complexity.gaming.help_i.controller.Session;

import com.complexity.gaming.help_i.domain.model.Session.IndividualSession;
import com.complexity.gaming.help_i.domain.model.Training.TrainingMaterial;
import com.complexity.gaming.help_i.domain.service.Session.IndividualSessionService;
import com.complexity.gaming.help_i.resource.Session.IndividualSessionResource;
import com.complexity.gaming.help_i.resource.Training.TrainingMaterialResource;
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
public class IndividualSessionsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IndividualSessionService individualSessionService;

    @GetMapping("/individualSessions")
    public Page<IndividualSessionResource> getAllIndividualSessions(Pageable pageable) {
        List<IndividualSessionResource> tags = individualSessionService.getAllIndividualSessions(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }
    @GetMapping("/individualSessions/{id}")
    public IndividualSessionResource getIndividualSessionById(@PathVariable(name = "id") Long individualSessionId) {
        return convertToResource(individualSessionService.getIndividualSessionById(individualSessionId));
    }
    @DeleteMapping("/individualSessions/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return individualSessionService.deleteIndividualSession(id);
    }

    private IndividualSessionResource convertToResource(IndividualSession entity) {
        return mapper.map(entity, IndividualSessionResource.class);
    }
}
