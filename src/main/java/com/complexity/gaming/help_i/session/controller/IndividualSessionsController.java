package com.complexity.gaming.help_i.session.controller;

import com.complexity.gaming.help_i.session.domain.model.IndividualSession;
import com.complexity.gaming.help_i.session.domain.service.IndividualSessionService;
import com.complexity.gaming.help_i.session.resource.IndividualSessionResource;
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
public class IndividualSessionsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IndividualSessionService individualSessionService;

    @Operation(summary = "Get all individual sessions", description = "Get all individual sessions", tags = {"individualSessions"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/individualSessions")
    public Page<IndividualSessionResource> getAllIndividualSessions(Pageable pageable) {
        List<IndividualSessionResource> tags = individualSessionService.getAllIndividualSessions(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }
    @Operation(summary = "Get individual session by id", description = "Get individual session by id", tags = {"individualSessions"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/individualSessions/{id}")
    public IndividualSessionResource getIndividualSessionById(@PathVariable(name = "id") Long individualSessionId) {
        return convertToResource(individualSessionService.getIndividualSessionById(individualSessionId));
    }
    @Operation(summary = "Delete individual session by id", description = "Delete individual session by id", tags = {"individualSessions"})
    @DeleteMapping("/individualSessions/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return individualSessionService.deleteIndividualSession(id);
    }

    private IndividualSessionResource convertToResource(IndividualSession entity) {
        return mapper.map(entity, IndividualSessionResource.class);
    }
}
