package com.complexity.gaming.help_i.resource.application;

import com.complexity.gaming.help_i.domain.model.application.ApplicationDetail;
import com.complexity.gaming.help_i.domain.model.application.ApplicationId;

public class SaveExpertApplicationResource {

    private ApplicationId tittle;
    private ApplicationDetail applicationDetails;

    public ApplicationId getTittle() {
        return tittle;
    }

    public SaveExpertApplicationResource setTittle(ApplicationId tittle) {
        this.tittle = tittle;
        return this;
    }

    public ApplicationDetail getApplicationDetails() {
        return applicationDetails;
    }

    public SaveExpertApplicationResource setApplicationDetails(ApplicationDetail applicationDetails) {
        this.applicationDetails = applicationDetails;
        return this;
    }
}
