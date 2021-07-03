package com.complexity.gaming.help_i.security.application;

import com.complexity.gaming.help_i.security.domain.model.Expert;
import com.complexity.gaming.help_i.security.domain.repository.ExpertRepository;
import com.complexity.gaming.help_i.security.domain.repository.PlayerRepository;
import com.complexity.gaming.help_i.security.domain.service.ExpertService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceImpl implements ExpertService {

    @Autowired
    private ExpertRepository expertRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Expert> getAllExperts(Pageable pageable) {
        return expertRepository.findAll(pageable);
    }

    @Override
    public Page<Expert> getAllByGameId(Pageable pageable, Long gameId) {
        return expertRepository.findByGame(pageable, gameId);
    }

    @Override
    public Expert getExpertById(Long expertId) {
        return expertRepository.findById(expertId)
                .orElseThrow(()-> new ResourceNotFoundException("Expert","Id",expertId));
    }
    @Override
    public Expert getExpertByEmail(String email) {
        return expertRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("Expert","email",email));
    }

    @Override
    public Expert createExpert(Expert expert) {
        if(playerRepository.findByEmail(expert.getEmail()).isPresent() || expertRepository.findByEmail(expert.getEmail()).isPresent())
            throw new ResourceNotFoundException("Email has already been taken");
        expert.setPassword(passwordEncoder.encode(expert.getPassword()));
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
