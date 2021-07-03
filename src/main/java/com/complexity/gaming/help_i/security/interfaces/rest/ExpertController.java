package com.complexity.gaming.help_i.security.interfaces.rest;

import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.service.ExpertService;
import com.complexity.gaming.help_i.security.application.transform.resource.ExpertResource;
import com.complexity.gaming.help_i.security.application.transform.resource.SaveExpertResource;
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
public class ExpertController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExpertService expertService;

    @GetMapping("/experts")
    public Page<ExpertResource> getAllExperts(Pageable pageable){
        List<ExpertResource> experts = expertService.getAllExperts(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        int expertCount = experts.size();
        return new PageImpl<>(experts, pageable, expertCount);
    }

    @GetMapping("/experts/{id}")
    public ExpertResource getExpertById(@PathVariable(name = "id") Long expertId){
        return convertToResource(expertService.getExpertById(expertId));
    }
    @GetMapping("/experts/email/{email}")
    public ExpertResource getExpertByEmail(@PathVariable(name = "email") String email){
        return convertToResource(expertService.getExpertByEmail(email));
    }

    @PostMapping("/experts/sign-up")
    public ExpertResource createExpert(@Valid @RequestBody SaveExpertResource resource){
        return convertToResource(expertService.createExpert(convertToEntity(resource)));
    }

    @PutMapping("/experts/{id}")
    public ExpertResource updateExpert(@PathVariable(name = "id") Long expertId, @Valid @RequestBody SaveExpertResource resource){

        return convertToResource(expertService.updateExpert(
        expertId, convertToEntity(resource)));
    }

    @DeleteMapping("/experts/{expertId}")
    public ResponseEntity<?> deleteExpert(@PathVariable Long expertId){
        return expertService.deleteExpert(expertId);
    }

    private Expert convertToEntity(SaveExpertResource resource){
        return mapper.map(resource, Expert.class);}

    private ExpertResource convertToResource(Expert entity){
        return mapper.map(entity, ExpertResource.class);
    }
}
