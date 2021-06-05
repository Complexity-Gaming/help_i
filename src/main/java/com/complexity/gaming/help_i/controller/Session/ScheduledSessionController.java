package com.complexity.gaming.help_i.controller.Session;

import com.complexity.gaming.help_i.domain.model.Session.ScheduledSession;
import com.complexity.gaming.help_i.domain.model.Training.TrainingMaterial;
import com.complexity.gaming.help_i.domain.service.Session.ScheduledSessionService;
import com.complexity.gaming.help_i.resource.Session.SaveScheduledSessionResource;
import com.complexity.gaming.help_i.resource.Session.ScheduledSessionResource;
import com.complexity.gaming.help_i.resource.Training.SaveTrainingMaterialResource;
import com.complexity.gaming.help_i.resource.Training.TrainingMaterialResource;
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

@RestController
@RequestMapping("/api")
public class ScheduledSessionController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ScheduledSessionService scheduledSessionService;

    @GetMapping("/scheduled")
    public Page<ScheduledSessionResource> getAllScheduledSessions(Pageable pageable) {
        List<ScheduledSessionResource> tags = scheduledSessionService.getAllScheduledSessions(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int tagCount = tags.size();
        return new PageImpl<>(tags, pageable, tagCount);
    }

    @GetMapping("/scheduled/{id}")
    public ScheduledSessionResource getScheduledSessionById(@PathVariable(name = "id") Long scheduledId) {
        return convertToResource(scheduledSessionService.getScheduledSessionById(scheduledId));
    }

    @PostMapping("/experts/{expertId}/scheduled")
    public ScheduledSessionResource ScheduleSession(@PathVariable Long expertId, Long playerId,
                                                            @Valid @RequestBody SaveScheduledSessionResource resource) {
        return convertToResource(scheduledSessionService.ScheduleSession(expertId, playerId, convertToEntity(resource)));
    }

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
