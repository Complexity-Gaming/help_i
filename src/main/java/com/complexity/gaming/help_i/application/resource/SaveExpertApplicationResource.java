package com.complexity.gaming.help_i.application.resource;

import com.complexity.gaming.help_i.application.domain.model.ApplicationDetail;
import com.complexity.gaming.help_i.application.domain.model.ApplicationId;

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
