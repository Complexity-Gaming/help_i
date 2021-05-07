package com.complexity.gaming.help_i.domain.service;

import com.complexity.gaming.help_i.domain.model.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ExpertService {

    Page<Expert> getAllExperts(Pageable pageable);
    Expert getExpertById(Long expertId);
    Expert createExpert(Expert expert);
    Expert updateExpert(Long expertId,Expert expertDetails);
    ResponseEntity<?> deleteExpert(Long expertId);
}
