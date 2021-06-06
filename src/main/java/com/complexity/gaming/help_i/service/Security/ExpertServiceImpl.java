package com.complexity.gaming.help_i.service.Security;

import com.complexity.gaming.help_i.domain.model.Security.Expert;
import com.complexity.gaming.help_i.domain.repository.Security.ExpertRepository;
import com.complexity.gaming.help_i.domain.service.Security.ExpertService;
import com.complexity.gaming.help_i.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertRepository expertRepository;


    @Override
    public Page<Expert> getAllExperts(Pageable pageable) {
        return expertRepository.findAll(pageable);
    }

    @Override
    public Expert getExpertById(Long expertId) {
        return expertRepository.findById(expertId)
                .orElseThrow(()-> new ResourceNotFoundException("Expert","Id",expertId));
    }

    @Override
    public Expert createExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    @Override
    public Expert updateExpert(Long expertId, Expert expertDetails) {
        return expertRepository.findById(expertId).map(expert -> {
            expert.setName(expertDetails.getName());
            expert.setEmail(expertDetails.getEmail());
            return expertRepository.save(expert);
        }).orElseThrow(()-> new ResourceNotFoundException("Expert","Id",expertId));
    }

    @Override
    public ResponseEntity<?> deleteExpert(Long expertId) {
        return expertRepository.findById(expertId).map(expert -> {
            expertRepository.delete(expert);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Expert","Id",expertId));
    }
}
