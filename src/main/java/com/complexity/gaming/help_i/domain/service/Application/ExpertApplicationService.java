package com.complexity.gaming.help_i.domain.service.Application;

import com.complexity.gaming.help_i.domain.model.Application.ExpertApplication;
import com.complexity.gaming.help_i.domain.model.Security.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ExpertApplicationService {

    Page<ExpertApplication> getAllExpertApplications(Pageable pageable);
    Page<ExpertApplication> getAllExpertApplicationsByApplicantId(Long applicantId, Pageable pageable);
    ExpertApplication getExpertApplicationById(Long expertApplicationId);
    ExpertApplication sendExpertApplication(Long applicantId, ExpertApplication expertApplication);
    Expert reviewApplication(Long expertApplicationId, String review, String reviewComment);
    ResponseEntity<?> deleteExpertApplication(Long expertApplicationId);
}
