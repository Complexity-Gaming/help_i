package com.complexity.gaming.help_i.session.controller;

import com.complexity.gaming.help_i.session.domain.model.ScheduledSession;
import com.complexity.gaming.help_i.session.domain.service.ScheduledSessionService;
import com.complexity.gaming.help_i.session.resource.SaveScheduledSessionResource;
import com.complexity.gaming.help_i.session.resource.ScheduledSessionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ScheduledSessionController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ScheduledSessionService scheduledSessionService;

    @Operation(summary = "Get all scheduled sessions", description = "Get all scheduled sessions", tags = {"scheduledSessions"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @GetMapping("/scheduled")
    public Page<ScheduledSessionResource> getAllScheduledSessions(Pageable pageable) {
        List<ScheduledSessionResource> tags = scheduledSessionService.getAllScheduledSessions(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }

    @Operation(summary = "Get scheduled session by id", description = "Get scheduled session by id", tags = {"scheduledSessions"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @GetMapping("/scheduled/{id}")
    public ScheduledSessionResource getScheduledSessionById(@PathVariable(name = "id") Long scheduledId) {
        return convertToResource(scheduledSessionService.getScheduledSessionById(scheduledId));
    }

    @Operation(summary = "Create scheduled session", description = "Create scheduled session", tags = {"scheduledSessions"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @PostMapping("/experts/{expertId}/scheduled")
    public ScheduledSessionResource ScheduleSession(@PathVariable Long expertId, Long playerId,
                                                            @Valid @RequestBody SaveScheduledSessionResource resource) {
        return convertToResource(scheduledSessionService.ScheduleSession(expertId, playerId, convertToEntity(resource)));
    }

    @Operation(summary = "Delete scheduled session", description = "Delete scheduled session", tags = {"scheduledSessions"})
    @ApiResponse(responseCode = "200", description = "successful operation")
    @DeleteMapping("/scheduled/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return scheduledSessionService.deleteScheduledSession(id);
    }

    private ScheduledSessionResource convertToResource(ScheduledSession entity) {
        return mapper.map(entity, ScheduledSessionResource.class);
    }

    ScheduledSession convertToEntity(SaveScheduledSessionResource resource) {
        return mapper.map(resource, ScheduledSession.class);
    }
}
