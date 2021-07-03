package com.complexity.gaming.help_i.security.interfaces.rest;

import com.complexity.gaming.help_i.security.application.transform.resource.ExpertResource;
import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.service.ExpertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/games/{gameId}/experts")
public class GameExpertsController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExpertService expertService;

    @GetMapping
    public Page<ExpertResource> getAllExpertsByGameId(Pageable pageable, @PathVariable(name = "gameId") Long gameId){
        List<ExpertResource> experts = expertService.getAllByGameId(pageable,gameId)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int expertCount = experts.size();
        return new PageImpl<>(experts, pageable, expertCount);
    }
    private ExpertResource convertToResource(Expert entity){
        return mapper.map(entity, ExpertResource.class);
    }
}
